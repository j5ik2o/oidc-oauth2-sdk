package com.github.j5ik2o.authnauthz.oidc.code

import com.github.j5ik2o.authnauthz.base
import com.github.j5ik2o.authnauthz.oauth2.{ AuthorizationCode, State }
import com.github.j5ik2o.authnauthz.oidc.ErrorType

sealed trait AuthenticationCodeResponse extends base.AuthorizationCodeBaseResponse

final case class AuthenticationSuccessfulCodeResponse(code: AuthorizationCode, state: Option[State])
    extends AuthenticationCodeResponse
    with base.AuthorizationSuccessfulCodeBaseResponse

final case class AuthenticationFailureCodeResponse(
    error: ErrorType,
    errorDescription: Option[String],
    errorURI: Option[String],
    state: Option[State]
) extends AuthenticationCodeResponse
    with base.AuthorizationFailureCodeBaseResponse
