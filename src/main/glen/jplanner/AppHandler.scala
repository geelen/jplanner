package glen.jplanner

import org.mortbay.jetty.{HttpConnection, Request, Response, Handler}
import scala.xml.Elem
object AppHandler {
  def get(): Handler = {
    new HandlerWrapper((target: String, dispatch: Int) => {
      val xml : Elem = <html><head><title>{target}</title></head><body><h1>{target}</h1>{body}</body></html>
      xml.toString
    })
  }

  def body() = {
    new HttpConnection()
  }
}