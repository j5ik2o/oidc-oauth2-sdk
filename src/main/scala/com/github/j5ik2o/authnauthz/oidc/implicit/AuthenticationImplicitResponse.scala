package com.github.j5ik2o.authnauthz.oidc.`implicit`

import com.github.j5ik2o.authnauthz.oauth2
import com.github.j5ik2o.authnauthz.oidc.{ AbstractTokenSuccessfulResponse, ErrorType, IdToken, Scopes }

import scala.concurrent.duration.Duration

trait TokenImplicitIssueResponse

final case class TokenImplicitIssueSuccessfulResponse(
    override val accessToken: oauth2.AccessToken,
    override val tokenType: String,
    override val expiresIn: Duration,
    override val idToken: IdToken,
    override val scopes: Scopes,
    state: oauth2.State
) extends AbstractTokenSuccessfulResponse(accessToken, tokenType, expiresIn, idToken, scopes)
    with TokenImplicitIssueResponse

final case class TokenImplicitIssueFailureResponse(
    override val error: ErrorType,
    override val errorDescription: Option[oauth2.ErrorDescription],
    override val errorUri: Option[oauth2.ErrorUri]
) extends oauth2.AbstractTokenFailureResponse(error, errorDescription, errorUri)
    with TokenImplicitIssueResponse
