package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.oauth2.{
  AbstractTokenFailureResponse,
  AbstractTokenSuccessfulResponse,
  ErrorType,
  Scopes,
  TokenResponse
}
import com.github.j5ik2o.authnauthz.{ AccessToken, RefreshToken }

import scala.concurrent.duration.Duration

sealed trait TokenCodeIssueResponse extends TokenResponse

final case class TokenCodeIssueSuccessfulResponse(
    override val accessToken: AccessToken,
    override val tokenType: String,
    override val expiresIn: Duration,
    refreshToken: Option[RefreshToken],
    override val scopes: Scopes
) extends AbstractTokenSuccessfulResponse(accessToken, tokenType, expiresIn, scopes)
    with TokenCodeIssueResponse

final case class TokenCodeIssueFailureResponse(
    override val error: ErrorType,
    override val errorDescription: Option[String],
    override val errorUri: Option[String]
) extends AbstractTokenFailureResponse(error, errorDescription, errorUri)
    with TokenCodeIssueResponse
