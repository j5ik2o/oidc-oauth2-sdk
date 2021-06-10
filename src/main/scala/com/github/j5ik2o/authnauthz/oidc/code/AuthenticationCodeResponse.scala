package com.github.j5ik2o.authnauthz.oidc.code

import com.github.j5ik2o.authnauthz.oauth2.{ AuthorizationCode, State }
import com.github.j5ik2o.authnauthz.oidc.ErrorType

sealed trait AuthenticationCodeResponse

final case class AuthenticationSuccessfulCodeResponse(code: AuthorizationCode, state: Option[State])
    extends AuthenticationCodeResponse

final case class AuthenticationFailureCodeResponse(
    error: ErrorType,
    errorDescription: Option[String],
    errorURI: Option[String],
    state: Option[State]
) extends AuthenticationCodeResponse
