package uk.co.boombastech.kotlinweb.http

import com.google.inject.servlet.GuiceFilter
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.DefaultServlet
import org.eclipse.jetty.servlet.ServletContextHandler
import uk.co.boombastech.kotlinweb.http.config.Config
import uk.co.boombastech.kotlinweb.http.controllers.Controller
import uk.co.boombastech.kotlinweb.http.filters.PostControllerFilter
import uk.co.boombastech.kotlinweb.http.filters.PostResponseFilter
import uk.co.boombastech.kotlinweb.http.filters.PreControllerFilter
import uk.co.boombastech.kotlinweb.http.requests.HttpMethod.GET
import uk.co.boombastech.kotlinweb.http.requests.KotlinWebCookie.userId
import uk.co.boombastech.kotlinweb.http.requests.Request
import uk.co.boombastech.kotlinweb.http.routing.Route
import uk.co.boombastech.kotlinweb.http.routing.Routes
import java.util.*
import javax.servlet.DispatcherType

fun main(args: Array<String>) {
    val config = Config()
    val server = Server(config.getProperty(Config.server.port))

    val servletContextHandler = ServletContextHandler(ServletContextHandler.SESSIONS);
    servletContextHandler.contextPath = "/"
    servletContextHandler.addEventListener(Listener(config))
    servletContextHandler.addFilter(GuiceFilter::class.java, "/*", EnumSet.allOf(DispatcherType::class.java))

    servletContextHandler.addServlet(DefaultServlet::class.java, "/")

    server.handler = servletContextHandler

    server.start()
    server.join()
}

class WebModuleTest : WebModule() {
    override fun globalFilters(): GlobalFilters {
        return GlobalFilters(
                RequestLoggerFilter::class
        )
    }

    override fun getRoutes(): Routes {
        return Routes(
                Route("/", GET, CookieViewerController::class, RequestLoggerFilter::class),
                Route("/cookie", GET, CookieViewerController::class),
                Route("/cookie/set", GET, CookieSetterController::class),
                Route("/cookie/delete", GET, CookieDeleteController::class)
        )
    }

    override fun wiring() {

    }
}

class RequestLoggerFilter : PreControllerFilter, PostControllerFilter, PostResponseFilter {
    override fun postControllerFilter(request: Request) {
        println("postControllerFilter")
    }

    override fun postResponseFilter(request: Request) {
        println("postResponseFilter")
    }

    override fun preControllerFilter(request: Request) {
        println("preControllerFilter")
    }
}

class CookieViewerController : Controller {
    override fun execute(request: Request): Response {
        var value: String = "default value"
        val get = request.cookies.get(userId)?.let { value = it.value }
        return DataResponse(value)
    }
}

class CookieSetterController : Controller {
    override fun execute(request: Request): Response {
        request.cookies.put(userId, "helloworld")
        return DataResponse("value set")
    }
}

class CookieDeleteController : Controller {
    override fun execute(request: Request): Response {
        request.cookies.get(userId)?.delete()
        return DataResponse("value deleted")
    }
}