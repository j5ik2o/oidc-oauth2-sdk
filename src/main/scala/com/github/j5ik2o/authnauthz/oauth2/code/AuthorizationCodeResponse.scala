package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.oauth2.ErrorType
import com.github.j5ik2o.authnauthz.{ AuthorizationCode, State }

trait AuthorizationCodeBaseResponse

trait AuthorizationSuccessfulCodeBaseResponse extends AuthorizationCodeBaseResponse {
  def code: AuthorizationCode
  def state: Option[State]
}

trait AuthorizationFailureCodeBaseResponse extends AuthorizationCodeBaseResponse {
  def error: com.github.j5ik2o.authnauthz.ErrorType
  def errorDescription: Option[String]
  def errorURI: Option[String]
  def state: Option[State]
}

sealed trait AuthorizationCodeResponse extends AuthorizationCodeBaseResponse

final case class AuthorizationSuccessfulCodeResponse(code: AuthorizationCode, state: Option[State])
    extends AuthorizationCodeResponse
    with AuthorizationSuccessfulCodeBaseResponse

final case class AuthorizationFailureCodeResponse(
    error: ErrorType,
    errorDescription: Option[String],
    errorURI: Option[String],
    state: Option[State]
) extends AuthorizationCodeResponse
    with AuthorizationFailureCodeBaseResponse
