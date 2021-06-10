package com.github.j5ik2o.authnauthz.base

import com.github.j5ik2o.authnauthz._
import com.github.j5ik2o.authnauthz.oauth2.{ ClientId, RedirectURI, State }

trait AuthorizationCodeBaseRequest extends oauth2.AuthorizationRequest {
  val responseTypes: ResponseTypes
  val clientId: ClientId
  val redirectURI: RedirectURI
  val scopes: Scopes
  val state: Option[State]
}
