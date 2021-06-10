package com.github.j5ik2o.authnauthz.oidc.code

import com.github.j5ik2o.authnauthz.oidc._
import com.github.j5ik2o.authnauthz.oauth2
import com.github.j5ik2o.authnauthz.oauth2.{ ErrorDescription, ErrorUri }

import scala.concurrent.duration.Duration

sealed trait TokenCodeIssueResponse extends TokenResponse

final case class TokenCodeIssueSuccessfulResponse(
    accessToken: oauth2.AccessToken,
    tokenType: String,
    refreshToken: Option[oauth2.RefreshToken],
    expiresIn: Duration,
    idToken: IdToken,
    scope: Scopes
)

final case class TokenCodeIssueFailureResponse(
    error: ErrorType,
    errorDescription: Option[ErrorDescription],
    errorUri: Option[ErrorUri]
)
