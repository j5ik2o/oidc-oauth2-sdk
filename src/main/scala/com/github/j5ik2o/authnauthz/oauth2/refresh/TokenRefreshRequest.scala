package com.github.j5ik2o.authnauthz.oauth2.refresh

import com.github.j5ik2o.authnauthz.oauth2.{ GrantType, RefreshToken, Scopes }

/** アクセストークン・更新リクエスト
  *
  * https://openid-foundation-japan.github.io/rfc6749.ja.html#token-refresh
  *
  * @param grantType
  * @param refreshToken
  * @param scopes
  */
final case class TokenRefreshRequest(
    grantType: GrantType,
    refreshToken: RefreshToken,
    scopes: Scopes
)
