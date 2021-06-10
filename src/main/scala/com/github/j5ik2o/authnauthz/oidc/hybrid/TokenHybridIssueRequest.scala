package com.github.j5ik2o.authnauthz.oidc.hybrid

import com.github.j5ik2o.authnauthz.oauth2.{ AuthorizationCode, ClientId, GrantType, RedirectURI }
import com.github.j5ik2o.authnauthz.oidc.TokenIssueRequest

final case class TokenHybridIssueRequest(
    grantType: GrantType,
    code: AuthorizationCode,
    redirectURI: RedirectURI,
    clientId: ClientId
) extends TokenIssueRequest {
  require(grantType == GrantType.AuthorizationCode)
}
