package com.github.j5ik2o.authnauthz.oauth2

import wvlet.airframe.ulid.ULID

final case class AuthorizationId(value: ULID)

sealed abstract class Authorization(
    val id: AuthorizationId,
    val clientId: ClientId,
    val redirectUri: RedirectUri,
    val scopes: Scopes
)

final case class CodeFlowAuthorization(
    override val id: AuthorizationId,
    override val clientId: ClientId,
    override val redirectUri: RedirectUri,
    override val scopes: Scopes,
    refreshToken: Option[RefreshToken]
) extends Authorization(id, clientId, redirectUri, scopes) {

  def withRefreshToken(refreshToken: Option[RefreshToken]): CodeFlowAuthorization = {
    copy(refreshToken = refreshToken)
  }

  def newAuthorizationCode(id: AuthorizationCodeId): AuthorizationCode = {
    AuthorizationCode(id)
  }

}
