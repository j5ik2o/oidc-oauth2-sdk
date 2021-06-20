package com.github.j5ik2o.authnauthz.oauth2

case class Client(clientId: ClientId, clientType: ClientType, clientSecret: ClientSecret, redirectUris: RedirectUris) {

  def mustRedirectUri: Boolean = {
    redirectUris.isMultiple || redirectUris.hasPartial || redirectUris.isEmpty
  }
}
