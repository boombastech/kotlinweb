package uk.co.boombastech.kotlinweb.http.routing

import uk.co.boombastech.kotlinweb.http.controllers.BadRequestController
import uk.co.boombastech.kotlinweb.http.controllers.Controller
import uk.co.boombastech.kotlinweb.http.requests.HttpMethod
import java.util.*
import kotlin.reflect.KClass

class Routes(vararg route: Route) {
    private val routes: List<Route> = route.toList()

    fun find(path: String, method: HttpMethod): KClass<out Controller> {
        try {
            return routes.first { route ->
                route.path.equals(path) && route.method.equals(method)
            }.controller
        } catch (noSuchElementException: NoSuchElementException) {
            return BadRequestController::class
        }
    }
}