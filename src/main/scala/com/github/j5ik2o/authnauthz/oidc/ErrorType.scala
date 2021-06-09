package com.github.j5ik2o.authnauthz.oidc

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
  //
  case object InteractionRequired      extends ErrorType("interaction_required")
  case object LoginRequired            extends ErrorType("login_required")
  case object AccountSelectionRequired extends ErrorType("account_selection_required")
  case object ConsentRequired          extends ErrorType("consent_required")
  case object InvalidRequest_uri       extends ErrorType("invalid_request_uri")
  case object InvalidRequest_object    extends ErrorType("invalid_request_object")
  case object RequestNotSupported      extends ErrorType("request_not_supported")
  case object RequestUriNotSupported   extends ErrorType("request_uri_not_supported")
  case object RegistrationNotSupported extends ErrorType("registration_not_supported")
}
