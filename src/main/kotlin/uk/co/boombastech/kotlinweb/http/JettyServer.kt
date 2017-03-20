package uk.co.boombastech.kotlinweb.http

import com.google.inject.servlet.GuiceFilter
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.DefaultServlet
import org.eclipse.jetty.servlet.ServletContextHandler
import uk.co.boombastech.kotlinweb.http.config.createProperties
import java.util.*
import javax.servlet.DispatcherType

fun main(args: Array<String>) {
    JettyServer.start()
}

object JettyServer {

    fun start() {
        val config = createProperties()
        val server = Server(config.port)

        val servletContextHandler = ServletContextHandler(ServletContextHandler.SESSIONS)
        servletContextHandler.contextPath = config.contextPath
        servletContextHandler.addEventListener(Listener(config))
        servletContextHandler.addFilter(GuiceFilter::class.java, "/*", EnumSet.allOf(DispatcherType::class.java))

        servletContextHandler.addServlet(DefaultServlet::class.java, "/")

        server.handler = servletContextHandler

        server.start()
        server.join()
    }
}