package com.github.j5ik2o.authnauthz.oidc

import com.github.j5ik2o.authnauthz.{ AuthorizationCode, State }

sealed trait AuthenticationResponse

final class AuthenticationSuccessfulCodeResponse(code: AuthorizationCode, state: State) extends AuthenticationResponse

final class AuthenticationErrorResponse(
    error: ErrorType,
    errorDescription: Option[String],
    errorURI: Option[String],
    state: Option[State]
) extends AuthenticationResponse
