package com.github.j5ik2o.authnauthz.oauth2.resourceOwnerPassword

import com.github.j5ik2o.authnauthz.oauth2.{ AccessToken, ErrorDescription, ErrorType, ErrorUri, Scopes, TokenResponse }

import scala.concurrent.duration.Duration

sealed trait TokenResourceOwnerPasswordIssueResponse extends TokenResponse

final case class TokenResourceOwnerPasswordIssueSuccessfulResponse(
    accessToken: AccessToken,
    tokenType: String,
    expiresIn: Duration,
    scopes: Scopes
) extends TokenResourceOwnerPasswordIssueResponse

final case class TokenResourceOwnerPasswordIssueFailureResponse(
    error: ErrorType,
    errorDescription: Option[ErrorDescription],
    errorUri: Option[ErrorUri]
) extends TokenResourceOwnerPasswordIssueResponse
