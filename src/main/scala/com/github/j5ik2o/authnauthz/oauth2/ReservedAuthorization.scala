package com.github.j5ik2o.authnauthz.oauth2

import java.time.Instant

case class ReservedAuthorization(
    id: AuthorizationCode,
    clientId: ClientId,
    responseTypes: ResponseTypes,
    redirectUri: RedirectUri,
    scopes: Scopes,
    state: Option[State],
    createdAt: Instant
)
