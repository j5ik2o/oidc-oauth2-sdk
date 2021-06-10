package com.github.j5ik2o.authnauthz.oidc.hybrid

import com.github.j5ik2o.authnauthz.oidc._
import com.github.j5ik2o.authnauthz.oauth2
import com.github.j5ik2o.authnauthz.oauth2.{ ErrorDescription, ErrorUri }

import scala.concurrent.duration.Duration

sealed trait TokenHybridIssueResponse

final case class TokenHybridIssueSuccessfulResponse(
    override val accessToken: oauth2.AccessToken,
    override val tokenType: String,
    refreshToken: Option[oauth2.RefreshToken],
    override val expiresIn: Duration,
    override val idToken: IdToken,
    scope: Scopes
) extends AbstractTokenSuccessfulResponse(accessToken, tokenType, expiresIn, idToken, scope)
    with TokenHybridIssueResponse

final case class TokenHybridIssueFailureResponse(
    override val error: ErrorType,
    override val errorDescription: Option[ErrorDescription],
    override val errorUri: Option[ErrorUri]
) extends oauth2.AbstractTokenFailureResponse(error, errorDescription, errorUri)
    with TokenHybridIssueResponse
