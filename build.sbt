import sbtcrossproject.CrossPlugin.autoImport.{ CrossType, crossProject }

organization in ThisBuild := "io.circe"

val root = project
  .in(file("."))
  .aggregate(notJavaTimeJs)
  .settings(publishSettings)
  .settings(
    publish := {},
    publishLocal := {},
    publishArtifact := false
  )

lazy val notJavaTime = crossProject(JSPlatform)
  .crossType(CrossType.Pure)
  .in(file("not-java-time"))
  .settings(publishSettings)
  .settings(
    moduleName := "not-java-time",
    libraryDependencies ++= Seq(
      "io.circe" %%% "circe-core" % "0.12.0-M3" % Test,
      "org.scalatest" %%% "scalatest" % "3.0.8"
    )
  )

lazy val notJavaTimeJs = notJavaTime.js

lazy val publishSettings = Seq(
  releaseCrossBuild := true,
  releasePublishArtifactsAction := PgpKeys.publishSigned.value,
  homepage := Some(url("https://github.com/circe/not-java-time")),
  licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  publishMavenStyle := true,
  publishArtifact in Test := false,
  pomIncludeRepository := { _ =>
    false
  },
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots".at(nexus + "content/repositories/snapshots"))
    else
      Some("releases".at(nexus + "service/local/staging/deploy/maven2"))
  },
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/circe/not-java-time"),
      "scm:git:git@github.com:circe/not-java-time.git"
    )
  ),
  developers := List(
    Developer(
      "travisbrown",
      "Travis Brown",
      "travisrobertbrown@gmail.com",
      url("https://twitter.com/travisbrown")
    )
  )
)

credentials ++= (
  for {
    username <- Option(System.getenv().get("SONATYPE_USERNAME"))
    password <- Option(System.getenv().get("SONATYPE_PASSWORD"))
  } yield Credentials(
    "Sonatype Nexus Repository Manager",
    "oss.sonatype.org",
    username,
    password
  )
).toSeq
