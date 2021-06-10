package com.github.j5ik2o.authnauthz.oidc.`implicit`

import com.github.j5ik2o.authnauthz.{ AccessToken, State }
import com.github.j5ik2o.authnauthz.oidc.{
  AbstractTokenFailureResponse,
  AbstractTokenSuccessfulResponse,
  ErrorType,
  IdToken,
  Scopes
}

import scala.concurrent.duration.Duration

trait TokenImplicitIssueResponse

final case class TokenImplicitIssueSuccessfulResponse(
    override val accessToken: AccessToken,
    override val tokenType: String,
    override val expiresIn: Duration,
    override val idToken: IdToken,
    override val scopes: Scopes,
    state: State
) extends AbstractTokenSuccessfulResponse(accessToken, tokenType, expiresIn, idToken, scopes)
    with TokenImplicitIssueResponse

final case class TokenImplicitIssueFailureResponse(
    override val error: ErrorType,
    override val errorDescription: Option[String],
    override val errorUri: Option[String]
) extends AbstractTokenFailureResponse(error, errorDescription, errorUri)
    with TokenImplicitIssueResponse
