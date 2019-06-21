# not-java-time

[![Build status](https://img.shields.io/travis/circe/not-java-time/master.svg)](https://travis-ci.org/circe/not-java-time)
[![Gitter](https://img.shields.io/badge/gitter-join%20chat-green.svg)](https://gitter.im/circe/circe)
[![Maven Central](https://img.shields.io/maven-central/v/io.circe/not-java-time_sjs0.6_2.13.svg)](https://maven-badges.herokuapp.com/maven-central/io.circe/not-java-time_sjs0.6_2.13)

### Wtf is this

This project is a mostly unimplemented `java.time` implementation.

### Why does it exist

`java.time` is a relatively not terrible library for working with dates and times that ships with
Java 8 and is therefore available to users of modern Scala versions on the JVM. Some Scala
libraries, like [circe][circe], refer to `java.time` classes, which is great for people working on
the JVM, but not for people using [Scala.js][scalajs], which does not provide an implementation of
`java.time` off the shelf.

Fortunately for Scala.js users who want to work with `java.time` (and libraries that depend on it),
there's at least one [solid, actively maintained implementation](https://github.com/cquiroz/scala-java-time)
that can be pulled in as an extra dependency. You'd add something like this to your build:

```scala
.jsSettings(
  libraryDependencies += "io.github.cquiroz" %%% "scala-java-time" % "2.0.0-RC3"
)
```
…and you get a fully-functional Scala.js implementation of `java.time`.


Unfortunately scala-java-time is huge, because a correct `java.time` implementation needs a bunch of
time zone stuff, etc. The size can be a problem for Scala.js applications.

The not-java-time library provides the most minimal implementation of a `java.time` package that
avoids linking errors for Scala.js users of circe (and possibly other libraries in the future). You
add this to your build:

```scala
.jsSettings(
  libraryDependencies += "io.circe" %%% "not-java-time" % "0.1.0"
)
```

…and your circe-using Scala.js project will compile without linking errors. If you try to use any of
the `java.time` encoders or decoders, you'll get a runtime error.

### Why don't you just make these instances JVM-only in circe

Because I kind of hate Scala.js and refuse to let it make more of a mess of my projects than it
already has and also I'm stubborn.

## License

not-java-time is licensed under the **[Apache License, Version 2.0][apache]** (the
"License"); you may not use this software except in compliance with the License.

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

[apache]: http://www.apache.org/licenses/LICENSE-2.0
[circe]: https://github.com/travisbrown/circe
[scala-java-time]: https://github.com/cquiroz/scala-java-time
[scalajs]: https://www.scala-js.org/

