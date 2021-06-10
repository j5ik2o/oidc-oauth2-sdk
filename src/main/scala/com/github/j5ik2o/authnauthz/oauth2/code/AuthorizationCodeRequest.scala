package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.base.AuthorizationCodeBaseRequest
import com.github.j5ik2o.authnauthz.oauth2.{
  AbstractAuthorizationRequest,
  AuthorizationRequest,
  ClientId,
  RedirectURI,
  ResponseType,
  ResponseTypes,
  Scopes,
  State
}

trait AuthorizationCodeRequest extends AuthorizationCodeBaseRequest {
  override val responseTypes: ResponseTypes
  override val scopes: Scopes
}

object AuthorizationCodeRequest {

  def apply(
      responseTypes: ResponseTypes,
      clientId: ClientId,
      redirectURI: RedirectURI,
      scopes: Scopes,
      state: Option[State]
  ): AuthorizationCodeRequest = AuthorizationCodeRequestImpl(responseTypes, clientId, redirectURI, scopes, state)

}

final case class AuthorizationCodeRequestImpl(
    override val responseTypes: ResponseTypes,
    override val clientId: ClientId,
    override val redirectURI: RedirectURI,
    override val scopes: Scopes,
    override val state: Option[State]
) extends AbstractAuthorizationRequest(responseTypes, clientId, redirectURI, scopes, state)
    with AuthorizationCodeRequest {
  require(responseTypes.values.contains(ResponseType.Code))
}
