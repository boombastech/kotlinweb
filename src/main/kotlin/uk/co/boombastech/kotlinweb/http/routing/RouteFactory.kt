package uk.co.boombastech.kotlinweb.http.routing

import com.google.inject.Injector
import uk.co.boombastech.kotlinweb.http.GlobalFilters
import uk.co.boombastech.kotlinweb.http.filters.Filter
import uk.co.boombastech.kotlinweb.http.requests.Request
import javax.inject.Inject

class RouteFactory @Inject constructor(val routes: Routes,
                                       val globalFilters: GlobalFilters,
                                       val injector: Injector) {

    fun find(request: Request): RequestHandler {
        val route = routes.find(request)
        val controller = injector.getInstance(route.controller.java)


        val filters = route.filters.map { filter ->
            injector.getInstance(filter.java)
        }

        val globalFilters = globalFilters.filters.map { filter ->
            injector.getInstance(filter.java)
        }

        val allFilters : MutableList<Filter> = mutableListOf()
        allFilters.addAll(globalFilters)
        allFilters.addAll(filters)

        return RequestHandler(controller, allFilters)
    }
}