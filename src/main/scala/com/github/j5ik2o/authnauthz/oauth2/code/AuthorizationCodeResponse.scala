package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.oauth2.{ AuthorizationCode, ErrorType, State }

sealed trait AuthorizationCodeResponse

final case class AuthorizationSuccessfulCodeResponse(code: AuthorizationCode, state: Option[State])
    extends AuthorizationCodeResponse

final case class AuthorizationFailureCodeResponse(
    error: ErrorType,
    errorDescription: Option[String],
    errorURI: Option[String],
    state: Option[State]
) extends AuthorizationCodeResponse
