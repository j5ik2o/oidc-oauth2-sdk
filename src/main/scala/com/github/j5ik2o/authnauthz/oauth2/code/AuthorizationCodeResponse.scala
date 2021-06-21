package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.oauth2._

sealed trait AuthorizationCodeResponse {
  def behaviorType: BehaviorType
  def clientId: ClientId
}

final case class AuthorizationSuccessfulCodeResponse(
    behaviorType: BehaviorType,
    refKey: RefKey,
    clientId: ClientId,
    clientName: ClientName,
    redirectUri: RedirectUri,
    scopes: Scopes,
    state: Option[State]
) extends AuthorizationCodeResponse

final case class AuthorizationFailureCodeResponse(
    behaviorType: BehaviorType,
    clientId: ClientId,
    redirectUri: Option[String],
    error: ErrorType,
    errorDescription: Option[String],
    errorURI: Option[String],
    state: Option[State]
) extends AuthorizationCodeResponse
