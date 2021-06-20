package com.github.j5ik2o.authnauthz.oauth2

import com.github.j5ik2o.uri.Uri

import java.text.ParseException

class RedirectUri(val uri: Uri) {
  def isFull: Boolean    = uri.query.nonEmpty
  def isPartial: Boolean = uri.path.isEmpty || uri.query.isEmpty

  def canEqual(obj: Any): Boolean = obj.isInstanceOf[RedirectUri]

  override def equals(obj: Any): Boolean = obj match {
    case that: RedirectUri if isFull =>
      println(s"Full: this = $this, that = $that")
      (that canEqual this) && uri.toString() == that.toString
    case that: RedirectUri if isPartial =>
      println(s"Partial: this = $this, that = $that")
      (that canEqual this) &&
      (uri.scheme == that.uri.scheme &&
      uri.authority == that.uri.authority &&
      uri.path == that.uri.path)
    case _ => false
  }

  override def hashCode(): Int = uri.hashCode()

  override def toString: String = uri.toString()

}

object RedirectUri {

  def apply(uri: Uri): RedirectUri = new RedirectUri(uri)

  def parseWithException(value: String): RedirectUri = {
    parse(value).fold(throw _, identity)
  }

  def parse(value: String): Either[ParseException, RedirectUri] = {
    Uri.parse(value).flatMap { uri =>
      if (!uri.isAbsolute) {
        Left(new ParseException(s"The redirect uri is not absolute. uri = $uri, ${uri.fragment}", 0))
      } else if (uri.query.exists(_.getParam("code").nonEmpty)) {
        Left(new ParseException("The query params in the redirect uri contains 'code'.", 0))
      } else if (uri.query.exists(_.getParam("state").nonEmpty)) {
        Left(new ParseException("The query params in the redirect uri contains 'state'.", 0))
      } else {
        Right(RedirectUri(uri))
      }
    }
  }

}

case class RedirectUris(values: Vector[RedirectUri]) {
  def isEmpty: Boolean              = values.isEmpty
  def nonEmpty: Boolean             = !isEmpty
  def isSingle: Boolean             = values.size == 1
  def isMultiple: Boolean           = !isSingle
  def toVector: Vector[RedirectUri] = values.toVector
  def hasPartial: Boolean           = values.exists(_.isPartial)
}
