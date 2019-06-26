package io.circe.njt

import io.circe.{ Decoder, Encoder, Json }
import org.scalatest.FunSuite

class NotJavaTimeTest extends FunSuite {
  test("Using Decoder should not throw linking errors") {
    assert(Decoder[List[String]].decodeJson(Json.arr()) === Right(Nil))
  }

  test("Using Encoder should not throw linking errors") {
    assert(Encoder[List[String]].apply(Nil) === Json.arr())
  }
}
