package com.github.j5ik2o.authnauthz.oauth2.`implicit`

import com.github.j5ik2o.authnauthz.oauth2.{
  AccessToken,
  ErrorDescription,
  ErrorType,
  ErrorUri,
  Scopes,
  State,
  TokenResponse,
  TokenType
}

import scala.concurrent.duration.Duration

sealed trait TokenImplicitIssueResponse extends TokenResponse

/** インプリシットフロー: アクセストークン・レスポンス
  *
  * @param accessToken [[AccessToken]]
  * @param tokenType [[]]
  * @param expiresIn
  * @param scopes [[Scopes]]
  * @param state
  */
final case class TokenImplicitIssueSuccessfulResponse(
    accessToken: AccessToken,
    tokenType: TokenType,
    expiresIn: Duration,
    scopes: Scopes,
    state: State
) extends TokenImplicitIssueResponse

/** インプリシットフロー: アクセストークン・エラーレスポンス
  *
  * @param error
  * @param errorDescription
  * @param errorUri
  */
final case class TokenImplicitIssueFailureResponse(
    error: ErrorType,
    errorDescription: Option[ErrorDescription],
    errorUri: Option[ErrorUri],
    state: State
) extends TokenImplicitIssueResponse
