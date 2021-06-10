package com.github.j5ik2o.authnauthz.base

import com.github.j5ik2o.authnauthz._
import com.github.j5ik2o.authnauthz.oauth2.{ ClientId, RedirectURI, State }

trait AuthorizationCodeBaseRequest extends oauth2.AuthorizationRequest {
  def responseTypes: ResponseTypes
  def clientId: ClientId
  def redirectURI: RedirectURI
  def scopes: Scopes
  def state: Option[State]
}
