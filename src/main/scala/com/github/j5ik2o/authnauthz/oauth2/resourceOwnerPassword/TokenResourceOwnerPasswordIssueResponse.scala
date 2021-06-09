package com.github.j5ik2o.authnauthz.oauth2.resourceOwnerPassword

import com.github.j5ik2o.authnauthz.AccessToken
import com.github.j5ik2o.authnauthz.oauth2.{
  AbstractTokenFailureResponse,
  AbstractTokenSuccessfulResponse,
  ErrorType,
  Scopes,
  TokenResponse
}

import scala.concurrent.duration.Duration

sealed trait TokenResourceOwnerPasswordIssueResponse extends TokenResponse

final case class TokenResourceOwnerPasswordIssueSuccessfulResponse(
    override val accessToken: AccessToken,
    override val tokenType: String,
    override val expiresIn: Duration,
    override val scopes: Scopes
) extends AbstractTokenSuccessfulResponse(accessToken, tokenType, expiresIn, scopes)
    with TokenResourceOwnerPasswordIssueResponse

final case class TokenResourceOwnerPasswordIssueFailureResponse(
    override val error: ErrorType,
    override val errorDescription: Option[String],
    override val errorUri: Option[String]
) extends AbstractTokenFailureResponse(error, errorDescription, errorUri)
    with TokenResourceOwnerPasswordIssueResponse
