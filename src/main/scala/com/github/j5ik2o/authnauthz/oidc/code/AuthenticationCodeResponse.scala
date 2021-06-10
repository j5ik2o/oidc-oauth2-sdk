package com.github.j5ik2o.authnauthz.oidc.code

import com.github.j5ik2o.authnauthz.oidc.ErrorType
import com.github.j5ik2o.authnauthz.{ AuthorizationCode, State }

sealed trait AuthenticationCodeResponse

final case class AuthenticationSuccessfulCodeResponse(code: AuthorizationCode, state: State)
    extends AuthenticationCodeResponse

final case class AuthenticationErrorResponse(
    error: ErrorType,
    errorDescription: Option[String],
    errorURI: Option[String],
    state: Option[State]
) extends AuthenticationCodeResponse
