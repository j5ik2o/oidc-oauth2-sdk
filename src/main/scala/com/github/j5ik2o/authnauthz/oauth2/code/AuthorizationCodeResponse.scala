package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.oauth2.ErrorType
import com.github.j5ik2o.authnauthz.{ AuthorizationCode, State }

sealed trait AuthorizationCodeResponse

final case class AuthorizationSuccessfulCodeResponse(code: AuthorizationCode, state: State)
    extends AuthorizationCodeResponse

final case class AuthorizationFailureCodeResponse(
    error: ErrorType,
    errorDescription: Option[String],
    errorURI: Option[String],
    state: Option[State]
) extends AuthorizationCodeResponse
