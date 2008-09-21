package glen.jplanner

import org.mortbay.jetty.{Request, Response, Handler}

object AppHandler {
  def get() : Handler = {
    new HandlerWrapper((target : String, request : Request, response : Response, dispatch : Int) => {
      println("target = " + target);
      println("request.getClass = " + request.getClass);
      println("response.getClass = " + response.getClass);
      println("dispatch = " + dispatch);
    })
  }
}