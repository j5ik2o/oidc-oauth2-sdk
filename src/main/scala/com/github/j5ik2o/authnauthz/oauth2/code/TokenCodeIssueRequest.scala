package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.oauth2.{
  AuthorizationCode,
  ClientId,
  ClientSecret,
  GrantType,
  RedirectUri,
  TokenIssueRequest
}

/** 認可コードフロー: アクセストークン・リクエスト
  *
  * https://openid-foundation-japan.github.io/rfc6749.ja.html#token-req
  */
final case class TokenCodeIssueRequest(
    grantType: GrantType,
    code: AuthorizationCode,
    redirectURI: RedirectUri,
    clientId: ClientId,
    clientSecret: ClientSecret
) extends TokenIssueRequest {
  require(grantType == GrantType.AuthorizationCode)
}
