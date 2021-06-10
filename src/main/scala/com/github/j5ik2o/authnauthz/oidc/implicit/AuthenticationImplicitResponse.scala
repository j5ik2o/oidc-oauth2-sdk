package com.github.j5ik2o.authnauthz.oidc.`implicit`

import com.github.j5ik2o.authnauthz.oauth2
import com.github.j5ik2o.authnauthz.oidc.{ ErrorType, IdToken, Scopes }

import scala.concurrent.duration.Duration

trait TokenImplicitIssueResponse

final case class TokenImplicitIssueSuccessfulResponse(
    accessToken: oauth2.AccessToken,
    tokenType: oauth2.TokenType,
    expiresIn: Duration,
    idToken: IdToken,
    scopes: Scopes,
    state: oauth2.State
) extends TokenImplicitIssueResponse

final case class TokenImplicitIssueFailureResponse(
    error: ErrorType,
    errorDescription: Option[oauth2.ErrorDescription],
    errorUri: Option[oauth2.ErrorUri]
) extends TokenImplicitIssueResponse
