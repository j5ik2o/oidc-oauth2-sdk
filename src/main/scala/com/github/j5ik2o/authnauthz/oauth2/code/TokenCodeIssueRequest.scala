package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.oauth2.{ AuthorizationCode, ClientId, GrantType, RedirectURI, TokenIssueRequest }

/** 認可コードフロー: アクセストークン・リクエスト
  *
  * https://openid-foundation-japan.github.io/rfc6749.ja.html#token-req
  *
  * @param grantType
  * @param code
  * @param redirectURI
  * @param clientId
  */
final case class TokenCodeIssueRequest(
    grantType: GrantType,
    code: AuthorizationCode,
    redirectURI: RedirectURI,
    clientId: ClientId
) extends TokenIssueRequest {
  require(grantType == GrantType.AuthorizationCode)
}
