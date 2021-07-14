package com.github.j5ik2o.authnauthz.oauth2.code

import com.github.j5ik2o.authnauthz.oauth2.{ BehaviorType, ClientId, ErrorType, RedirectUri, State }

trait AuthorizationCodeApproveResponse {
  def behaviorType: BehaviorType
  def clientId: ClientId
}

final case class AuthorizationCodeApproveSuccessfulResponse(
    behaviorType: BehaviorType,
    clientId: ClientId,
    redirectUri: RedirectUri
) extends AuthorizationCodeApproveResponse

final case class AuthorizationCodeApproveFailureResponse(
    behaviorType: BehaviorType,
    clientId: ClientId,
    redirectUri: Option[String],
    error: ErrorType,
    errorDescription: Option[String],
    errorURI: Option[String],
    state: Option[State]
) extends AuthorizationCodeApproveResponse
