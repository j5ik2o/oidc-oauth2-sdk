package com.github.j5ik2o.authnauthz.oauth2.refresh

import com.github.j5ik2o.authnauthz.oauth2.{
  AbstractTokenFailureResponse,
  AbstractTokenSuccessfulResponse,
  AccessToken,
  ErrorDescription,
  ErrorType,
  ErrorUri,
  RefreshToken,
  Scopes,
  TokenResponse
}

import scala.concurrent.duration.Duration

sealed trait TokenRefreshResponse extends TokenResponse

/** アクセストークン・レスポンス
  *
  * https://openid-foundation-japan.github.io/rfc6749.ja.html#token-response
  *
  * @param accessToken
  * @param tokenType
  * @param expiresIn
  * @param refreshToken
  * @param scopes
  */
final case class TokenRefreshSuccessfulResponse(
    override val accessToken: AccessToken,
    override val tokenType: String,
    override val expiresIn: Duration,
    refreshToken: Option[RefreshToken],
    override val scopes: Scopes
) extends AbstractTokenSuccessfulResponse(accessToken, tokenType, expiresIn, scopes)
    with TokenRefreshResponse

final case class TokenRefreshFailureResponse(
    override val error: ErrorType,
    override val errorDescription: Option[ErrorDescription],
    override val errorUri: Option[ErrorUri]
) extends AbstractTokenFailureResponse(error, errorDescription, errorUri)
    with TokenRefreshResponse