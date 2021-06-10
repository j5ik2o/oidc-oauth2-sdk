package com.github.j5ik2o.authnauthz.oauth2.refresh

import com.github.j5ik2o.authnauthz.oauth2.{
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
    accessToken: AccessToken,
    tokenType: String,
    expiresIn: Duration,
    refreshToken: Option[RefreshToken],
    scopes: Scopes
) extends TokenRefreshResponse

final case class TokenRefreshFailureResponse(
    error: ErrorType,
    errorDescription: Option[ErrorDescription],
    errorUri: Option[ErrorUri]
) extends TokenRefreshResponse
