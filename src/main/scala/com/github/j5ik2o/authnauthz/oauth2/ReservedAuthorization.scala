package com.github.j5ik2o.authnauthz.oauth2

import java.time.Instant

case class ReservedAuthorizationId(value: RefKey)

case class ReservedAuthorization(
    id: ReservedAuthorizationId,
    clientId: ClientId,
    responseTypes: ResponseTypes,
    redirectUri: RedirectUri,
    scopes: Scopes,
    state: Option[State],
    createdAt: Instant
) {
  def refKey: RefKey = id.value

  def newCodeFlowAuthorization(id: AuthorizationId): Authorization = {
    CodeFlowAuthorization(id, clientId, redirectUri, scopes, None)
  }

}
