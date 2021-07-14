package com.github.j5ik2o.authnauthz.oauth2

final case class Client(
    clientId: ClientId,
    clientName: ClientName,
    clientType: ClientType,
    clientSecret: ClientSecret,
    redirectUris: RedirectUris
) {

  def mustRedirectUri: Boolean = {
    redirectUris.isMultiple || redirectUris.hasPartial || redirectUris.isEmpty
  }
}
