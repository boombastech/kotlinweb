package uk.co.boombastech.kotlinweb.http.internal

import uk.co.boombastech.kotlinweb.http.WebModule
import uk.co.boombastech.kotlinweb.http.requests.HttpMethod.GET
import uk.co.boombastech.kotlinweb.http.requests.HttpMethod.POST
import uk.co.boombastech.kotlinweb.http.routing.Route
import uk.co.boombastech.kotlinweb.http.routing.Routes

class InternalModule : WebModule() {
    override fun getRoutes(): Routes {
        return Routes(
                Route(path = "/internal/status", controller = PropertiesController::class, method = GET),
                Route(path = "/internal/status", controller = PropertyEditorController::class, method = POST)
        )
    }

    override fun wiring() {

    }
}