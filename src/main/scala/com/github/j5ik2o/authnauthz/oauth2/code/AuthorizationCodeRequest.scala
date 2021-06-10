package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.base
import com.github.j5ik2o.authnauthz.oauth2._

final case class AuthorizationCodeRequest(
    override val responseTypes: ResponseTypes,
    override val clientId: ClientId,
    override val redirectURI: RedirectURI,
    override val scopes: Scopes,
    override val state: Option[State]
) extends AbstractAuthorizationRequest(responseTypes, clientId, redirectURI, scopes, state)
    with base.AuthorizationCodeBaseRequest {
  require(responseTypes.values.contains(ResponseType.Code))
}
