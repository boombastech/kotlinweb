package uk.co.boombastech.kotlinweb.http

import com.google.inject.servlet.ServletModule
import uk.co.boombastech.kotlinweb.http.requests.RequestFactory
import uk.co.boombastech.kotlinweb.http.routing.RouteFactory
import uk.co.boombastech.kotlinweb.http.routing.Routes
import uk.co.boombastech.kotlinweb.http.servlets.ControllerServlet

abstract class WebModule() : ServletModule() {
    override fun configureServlets() {
        wiring()
        bindRoutes()
    }

    private fun bindRoutes() {
        bind(RequestFactory::class.java)
        bind(Routes::class.java).toInstance(getRoutes())
        bind(RouteFactory::class.java)

        serve("*").with(ControllerServlet::class.java)
    }

    abstract fun getRoutes(): Routes
    abstract fun wiring()
}