package com.github.j5ik2o.authnauthz.oidc.code

import com.github.j5ik2o.authnauthz.oidc._
import com.github.j5ik2o.authnauthz.oauth2
import com.github.j5ik2o.authnauthz.oauth2.{ ErrorDescription, ErrorUri }

import scala.concurrent.duration.Duration

sealed trait TokenCodeIssueResponse extends TokenResponse

final case class TokenCodeIssueSuccessfulResponse(
    override val accessToken: oauth2.AccessToken,
    override val tokenType: String,
    refreshToken: Option[oauth2.RefreshToken],
    override val expiresIn: Duration,
    override val idToken: IdToken,
    scope: Scopes
) extends AbstractTokenSuccessfulResponse(accessToken, tokenType, expiresIn, idToken, scope)
    with TokenCodeIssueResponse

final case class TokenCodeIssueFailureResponse(
    override val error: ErrorType,
    override val errorDescription: Option[ErrorDescription],
    override val errorUri: Option[ErrorUri]
) extends oauth2.AbstractTokenFailureResponse(error, errorDescription, errorUri)
    with TokenCodeIssueResponse
