package com.github.j5ik2o.authnauthz.base

import com.github.j5ik2o.authnauthz.oauth2

trait AuthorizationImplicitBaseRequest {
  def responseTypes: ResponseTypes
  def clientId: oauth2.ClientId
  def redirectURI: oauth2.RedirectURI
  def scopes: Scopes
  def state: Option[oauth2.State]
}
