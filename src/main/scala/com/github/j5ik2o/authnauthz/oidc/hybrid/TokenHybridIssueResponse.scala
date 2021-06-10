package com.github.j5ik2o.authnauthz.oidc.hybrid

import com.github.j5ik2o.authnauthz.oidc._
import com.github.j5ik2o.authnauthz.oauth2
import com.github.j5ik2o.authnauthz.oauth2.{ ErrorDescription, ErrorUri, TokenType }

import scala.concurrent.duration.Duration

sealed trait TokenHybridIssueResponse

final case class TokenHybridIssueSuccessfulResponse(
    accessToken: oauth2.AccessToken,
    tokenType: TokenType,
    refreshToken: Option[oauth2.RefreshToken],
    expiresIn: Duration,
    idToken: IdToken,
    scope: Scopes
) extends TokenHybridIssueResponse

final case class TokenHybridIssueFailureResponse(
    error: ErrorType,
    errorDescription: Option[ErrorDescription],
    errorUri: Option[ErrorUri]
) extends TokenHybridIssueResponse
