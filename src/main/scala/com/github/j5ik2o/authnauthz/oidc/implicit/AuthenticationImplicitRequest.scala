package com.github.j5ik2o.authnauthz.oidc.`implicit`

import com.github.j5ik2o.authnauthz.oauth2.{ ClientId, RedirectURI, State }
import com.github.j5ik2o.authnauthz.oidc.{ Nonce, ResponseTypes, Scopes }

final case class AuthenticationImplicitRequest(
    responseTypes: ResponseTypes,
    clientId: ClientId,
    redirectURI: RedirectURI,
    scopes: Scopes,
    state: Option[State],
    nonce: Nonce
)
