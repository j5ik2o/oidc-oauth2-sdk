package com.github.j5ik2o.authnauthz.oidc.code

import com.github.j5ik2o.authnauthz.oauth2.{ AuthorizationCode, ClientId, GrantType, RedirectUri }

final case class TokenCodeIssueRequest(
    grantType: GrantType,
    code: AuthorizationCode,
    redirectURI: RedirectUri,
    clientId: ClientId
) {
  require(grantType == GrantType.AuthorizationCode)
}
