package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.{ ClientId, RedirectURI, State }
import com.github.j5ik2o.authnauthz.oauth2.{
  AbstractAuthorizationRequest,
  AuthorizationRequest,
  ResponseType,
  ResponseTypes,
  Scopes
}

trait AuthorizationCodeBaseRequest extends AuthorizationRequest {
  val responseTypes: com.github.j5ik2o.authnauthz.ResponseTypes
  val clientId: ClientId
  val redirectURI: RedirectURI
  val scopes: com.github.j5ik2o.authnauthz.Scopes
  val state: Option[State]
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
