package uk.co.boombastech.kotlinweb.http.routing

import com.google.inject.Injector
import uk.co.boombastech.kotlinweb.http.requests.Request
import javax.inject.Inject

class RouteFactory @Inject constructor(val routes: Routes, val injector: Injector) {

    fun find(request: Request): RequestHandler {
        val route = routes.find(request)
        val controller = injector.getInstance(route.controller.java)

        val filters = route.filters.map { filter ->
            injector.getInstance(filter.java)
        }

        return RequestHandler(controller, filters)
    }
}