package com.github.j5ik2o.authnauthz.oauth2.clientCredentail

import com.github.j5ik2o.authnauthz.oauth2.{ GrantType, Scopes, TokenIssueRequest }

/** クライアントクレデンシャルフロー: トークン・リクエスト
  *
  * @param grantType
  * @param scopes
  */
final case class TokenClientCredentialIssueRequest(grantType: GrantType, scopes: Scopes) extends TokenIssueRequest
