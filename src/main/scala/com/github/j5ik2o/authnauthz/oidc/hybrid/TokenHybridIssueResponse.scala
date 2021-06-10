package com.github.j5ik2o.authnauthz.oidc.hybrid

import com.github.j5ik2o.authnauthz.oidc._
import com.github.j5ik2o.authnauthz.oauth2.{ AccessToken, RefreshToken }

import scala.concurrent.duration.Duration

sealed trait TokenHybridIssueResponse

final case class TokenHybridIssueSuccessfulResponse(
    override val accessToken: AccessToken,
    override val tokenType: String,
    refreshToken: Option[RefreshToken],
    override val expiresIn: Duration,
    override val idToken: IdToken,
    scope: Scopes
) extends AbstractTokenSuccessfulResponse(accessToken, tokenType, expiresIn, idToken, scope)
    with TokenHybridIssueResponse

final case class TokenHybridIssueFailureResponse(
    override val error: ErrorType,
    override val errorDescription: Option[String],
    override val errorUri: Option[String]
) extends AbstractTokenFailureResponse(error, errorDescription, errorUri)
    with TokenHybridIssueResponse
