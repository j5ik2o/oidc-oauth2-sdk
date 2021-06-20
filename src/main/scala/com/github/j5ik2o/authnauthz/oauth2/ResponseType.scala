package com.github.j5ik2o.authnauthz.oauth2

import enumeratum._

sealed abstract class ResponseType(override val entryName: String) extends EnumEntry

object ResponseType extends Enum[ResponseType] {
  override def values: IndexedSeq[ResponseType] = findValues

  case object Code  extends ResponseType("code")
  case object Token extends ResponseType("token")

}

final case class ResponseTypes(values: Set[ResponseType]) {
  require(values.nonEmpty, "values is empty.")
}

object ResponseTypes {

  def apply(values: ResponseType*): ResponseTypes = {
    new ResponseTypes(values.toSet)
  }

  def parseWithException(text: Option[String]): ResponseTypes =
    parse(text).fold(throw _, identity)

  def parse(text: Option[String]): Either[OAuth2Exception, ResponseTypes] = {
    text match {
      case None =>
        Left(new OAuth2Exception(ErrorType.InvalidRequest))
      case Some("") =>
        Left(new OAuth2Exception(ErrorType.InvalidRequest))
      case Some(values) =>
        val responseTypeTexts = values.split(" ")
        if (!responseTypeTexts.exists(ResponseType.values.contains))
          Left(new OAuth2Exception(ErrorType.UnsupportedResponseType))
        else
          Right(ResponseTypes(responseTypeTexts.map(ResponseType.withName).toSet))
    }
  }

}
