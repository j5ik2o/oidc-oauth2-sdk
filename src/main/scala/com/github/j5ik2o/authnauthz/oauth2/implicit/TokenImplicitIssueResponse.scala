package com.github.j5ik2o.authnauthz.oauth2.`implicit`

import com.github.j5ik2o.authnauthz.oauth2.{
  AbstractTokenFailureResponse,
  AbstractTokenSuccessfulResponse,
  ErrorType,
  Scopes,
  TokenResponse
}
import com.github.j5ik2o.authnauthz.{ AccessToken, State }

import scala.concurrent.duration.Duration

sealed trait TokenImplicitIssueResponse extends TokenResponse

/** インプリシットフロー: アクセストークン・レスポンス
  *
  * @param accessToken
  * @param tokenType
  * @param expiresIn
  * @param scopes
  * @param state
  */
final case class TokenImplicitIssueSuccessfulResponse(
    override val accessToken: AccessToken,
    override val tokenType: String,
    override val expiresIn: Duration,
    override val scopes: Scopes,
    state: State
) extends AbstractTokenSuccessfulResponse(accessToken, tokenType, expiresIn, scopes)
    with TokenImplicitIssueResponse

/** インプリシットフロー: アクセストークン・エラーレスポンス
  *
  * @param error
  * @param errorDescription
  * @param errorUri
  */
final case class TokenImplicitIssueFailureResponse(
    override val error: ErrorType,
    override val errorDescription: Option[String],
    override val errorUri: Option[String],
    state: State
) extends AbstractTokenFailureResponse(error, errorDescription, errorUri)
    with TokenImplicitIssueResponse
