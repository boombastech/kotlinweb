package uk.co.boombastech.kotlinweb.http.routing

import uk.co.boombastech.kotlinweb.http.controllers.BadRequestController
import uk.co.boombastech.kotlinweb.http.controllers.Controller
import uk.co.boombastech.kotlinweb.http.filters.Filter
import uk.co.boombastech.kotlinweb.http.requests.Request
import java.util.*
import kotlin.reflect.KClass

class Routes(vararg route: Route) {
    private val routes: List<Route> = route.toList()

    fun find(request: Request): Route {
        try {
            return routes.first { route ->
                route.path.equals(request.url.path) && route.method.equals(request.method)
            }
        } catch (noSuchElementException: NoSuchElementException) {
            return Route(request.url.path, request.method, BadRequestController::class)
        }
    }
}