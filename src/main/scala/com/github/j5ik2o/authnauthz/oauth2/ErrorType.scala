package com.github.j5ik2o.authnauthz.oauth2

import enumeratum._

sealed abstract class ErrorType(override val entryName: String)
    extends EnumEntry
    with com.github.j5ik2o.authnauthz.ErrorType

object ErrorType extends Enum[ErrorType] {
  override def values: IndexedSeq[ErrorType] = findValues
  case object InvalidRequest          extends ErrorType("invalid_request")
  case object UnauthorizedClient      extends ErrorType("unauthorized_client")
  case object AccessDenied            extends ErrorType("access_denied")
  case object UnsupportedResponseType extends ErrorType("unsupported_response_type")
  case object InvalidScope            extends ErrorType("invalid_scope")
  case object ServerError             extends ErrorType("server_error")
  case object TemporarilyUnavailable  extends ErrorType("temporarily_unavailable")
}
