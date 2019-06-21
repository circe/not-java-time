package io.circe.njt

import io.circe.{ Decoder, Json }
import org.scalatest.FunSuite

class NotJavaTimeTest extends FunSuite {
  test("Using circe should not throw linking errors") {
    assert(Decoder[List[String]].decodeJson(Json.arr()) === Right(Nil))
  }
}
