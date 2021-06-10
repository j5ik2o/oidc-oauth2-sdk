package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.base.{
  AuthorizationCodeBaseResponse,
  AuthorizationFailureCodeBaseResponse,
  AuthorizationSuccessfulCodeBaseResponse
}
import com.github.j5ik2o.authnauthz.oauth2.{ AuthorizationCode, ErrorType, State }

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
