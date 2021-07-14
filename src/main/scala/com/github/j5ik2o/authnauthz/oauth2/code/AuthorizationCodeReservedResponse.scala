package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.oauth2._

sealed trait AuthorizationCodeReservedResponse {
  def behaviorType: BehaviorType
  def clientId: ClientId
}

final case class AuthorizationCodeSuccessfulResponse(
    behaviorType: BehaviorType,
    refKey: RefKey,
    clientId: ClientId,
    clientName: ClientName,
    redirectUri: RedirectUri,
    scopes: Scopes,
    state: Option[State]
) extends AuthorizationCodeReservedResponse

final case class AuthorizationCodeFailureResponse(
    behaviorType: BehaviorType,
    clientId: ClientId,
    redirectUri: Option[String],
    error: ErrorType,
    errorDescription: Option[String],
    errorURI: Option[String],
    state: Option[State]
) extends AuthorizationCodeReservedResponse
