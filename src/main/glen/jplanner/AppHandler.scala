package glen.jplanner

import org.mortbay.jetty.{Request, Response, Handler}
import javax.servlet.http.HttpServletResponse.SC_OK

object AppHandler {
  def get(): Handler = {
    new HandlerWrapper((target: String, request: Request, response: Response, dispatch: Int) => {
      response.setContentType("text/html")
      response.setStatus(SC_OK)
      response.getWriter().println(<html><head><title>{target}</title></head><body><h1>{target}</h1></body></html>)
      request.setHandled(true)
    })
  }
}