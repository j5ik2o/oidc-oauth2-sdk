package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.oauth2.{ BehaviorType, ClientId, ErrorType, RedirectUri, State }

trait AuthorizationCodeDenyResponse {
  def behaviorType: BehaviorType
  def clientId: ClientId
}

final case class AuthorizationCodeDenySuccessfulResponse(
    behaviorType: BehaviorType,
    clientId: ClientId,
    redirectUri: RedirectUri
) extends AuthorizationCodeDenyResponse

final case class AuthorizationCodeDenyFailureResponse(
    behaviorType: BehaviorType,
    clientId: ClientId,
    redirectUri: Option[String],
    error: ErrorType,
    errorDescription: Option[String],
    errorURI: Option[String],
    state: Option[State]
) extends AuthorizationCodeDenyResponse
