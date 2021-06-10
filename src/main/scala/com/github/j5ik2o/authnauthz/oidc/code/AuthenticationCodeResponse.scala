package com.github.j5ik2o.authnauthz.oidc.code

import com.github.j5ik2o.authnauthz.oauth2.code.{
  AuthorizationCodeBaseResponse,
  AuthorizationFailureCodeBaseResponse,
  AuthorizationSuccessfulCodeBaseResponse
}
import com.github.j5ik2o.authnauthz.oidc.ErrorType
import com.github.j5ik2o.authnauthz.{ AuthorizationCode, State }

sealed trait AuthenticationCodeResponse extends AuthorizationCodeBaseResponse

final case class AuthenticationSuccessfulCodeResponse(code: AuthorizationCode, state: Option[State])
    extends AuthenticationCodeResponse
    with AuthorizationSuccessfulCodeBaseResponse

final case class AuthenticationFailureCodeResponse(
    error: ErrorType,
    errorDescription: Option[String],
    errorURI: Option[String],
    state: Option[State]
) extends AuthenticationCodeResponse
    with AuthorizationFailureCodeBaseResponse
