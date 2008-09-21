package glen.jplanner

import org.mortbay.jetty.{Request, Response, Handler}
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import org.mortbay.jetty.handler.AbstractHandler
import javax.servlet.http.HttpServletResponse.SC_OK

class HandlerWrapper(contentGenerator : (String, Int) => String) extends AbstractHandler {
  def handle(target: String, request: HttpServletRequest, response: HttpServletResponse, dispatch: Int) {
    request match {
      case jettyRequest: Request => {
        response match {
          case jettyResponse: Response => {
            typedHandle(target, jettyRequest, jettyResponse, dispatch)
          }
          case _ => println("Response not a jetty.Response!")
        }
      }
      case _ => println("Request not a jetty.Request");
    }
  }

  def typedHandle(target : String, request : Request, response : Response, dispatch : Int) {
    response.setContentType("text/html")
    response.setStatus(SC_OK)
    response.getWriter().println(contentGenerator(target, dispatch))
    request.setHandled(true)
  }
}