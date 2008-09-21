package glen.jplanner

import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import org.mortbay.jetty.handler.{HandlerList, ResourceHandler, DefaultHandler, AbstractHandler}
import org.mortbay.jetty.servlet.Context
import org.mortbay.jetty.{Handler, Server};
import org.mortbay.jetty.handler.{DefaultHandler, HandlerList, ResourceHandler};

object Main {
  def main(args: Array[String]) {
    val port = 8081
    val server = new Server(port)

    val resourceHandler = new ResourceHandler()
    resourceHandler.setResourceBase("www")
    server.setHandlers(Array[Handler](resourceHandler, AppHandler.get))
//    server.setHandler(resourceHandler)

    server.start()
    server.join()

    println("Hello World!");
  }
}