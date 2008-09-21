package glen.jplanner

import org.mortbay.jetty.{Request, Response, Handler}
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import org.mortbay.jetty.handler.AbstractHandler

class HandlerWrapper(handle: (String, Request, Response, Int) => Unit) extends AbstractHandler {
  def handle(target: String, request: HttpServletRequest, response: HttpServletResponse, dispatch: Int) {
    request match {
      case jettyRequest: Request => {
        response match {
          case jettyResponse: Response => {
            handle(target, jettyRequest, jettyResponse, dispatch)
          }
          case _ => println("Response not a jetty.Response!")
        }
      }
      case _ => println("Request not a jetty.Request");
    }
  }
}