package com.github.j5ik2o.authnauthz.oidc.code

import com.github.j5ik2o.authnauthz.oauth2.{ AuthorizationCode, ClientId, GrantType, RedirectURI }
import com.github.j5ik2o.authnauthz.oidc

final case class TokenCodeIssueRequest(
    grantType: GrantType,
    code: AuthorizationCode,
    redirectURI: RedirectURI,
    clientId: ClientId
) extends oidc.TokenIssueRequest {
  require(grantType == GrantType.AuthorizationCode)
}
