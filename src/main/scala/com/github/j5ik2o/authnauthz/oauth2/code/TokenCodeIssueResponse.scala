package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.oauth2.{
  AccessToken,
  ErrorDescription,
  ErrorType,
  ErrorUri,
  RefreshToken,
  Scopes,
  TokenResponse
}

import scala.concurrent.duration.Duration

sealed trait TokenCodeIssueResponse extends TokenResponse

final case class TokenCodeIssueSuccessfulResponse(
    accessToken: AccessToken,
    tokenType: String,
    expiresIn: Duration,
    refreshToken: Option[RefreshToken],
    scopes: Scopes
) extends TokenCodeIssueResponse

final case class TokenCodeIssueFailureResponse(
    error: ErrorType,
    errorDescription: Option[ErrorDescription],
    errorUri: Option[ErrorUri]
) extends TokenCodeIssueResponse
