package com.github.j5ik2o.authnauthz

trait RequestHandler[SELF, Req, Res] {
  type Output[_]
  def execute(self: SELF, req: Req): Output[Res]
}

trait ClientAuthenticator[SELF, REQ, RES] {
  type Output[_]
  def execute(self: SELF, req: REQ): Output[RES]
}
