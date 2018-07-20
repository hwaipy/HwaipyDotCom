package com.hydra.web

import java.util.concurrent.{CountDownLatch, TimeUnit}
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.Handler
import org.eclipse.jetty.server.handler.{HandlerList, ResourceHandler}
import org.eclipse.jetty.servlet.{ServletContextHandler, ServletHolder}

import scala.concurrent.Future
import scala.io.Source
import scala.concurrent.ExecutionContext.Implicits.global

object WydraApp extends App {
  val webPort = 20080
  val webServer = new Server(webPort)

  val servletContext = new ServletContextHandler(ServletContextHandler.SESSIONS)
  servletContext.addServlet(new ServletHolder(new WeatherServlet()), WeatherServlet.path)
  //  servletContext.addServlet(new ServletHolder(new MsgPackRequestServlet()), MsgPackRequestServlet.path)
  //  servletContext.addServlet(new ServletHolder(new HydraLocalServlet(Paths.get("res/hydralocal/"))), HydraLocalServlet.path)
  //  servletContext.addServlet(new ServletHolder(new MD2HTMLServlet()), "/")
  servletContext.setContextPath("/wydra")

  val fileContext = new ResourceHandler()
  fileContext.setResourceBase("res")
  fileContext.setStylesheet("")
  println(fileContext.setRedirectWelcome(true))
  fileContext.setWelcomeFiles(Array[String]("index.html"))

  val handlers = new HandlerList()
  handlers.setHandlers(Array[Handler](servletContext, fileContext))
  webServer.setHandler(handlers)
  webServer.start
  println(s"Wydra WebServer started on port $webPort.")

  val latch = new CountDownLatch(1)
  Future {
    Source.stdin.getLines.filter(line => line.toLowerCase == "q").next
    latch.countDown
  }
  latch.await(12, TimeUnit.HOURS)
  println("Stoping Wydra WebServer...")
  webServer.stop
}
