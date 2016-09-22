package uk.co.boombastech.kotlinweb.http.routing

import com.google.inject.Injector
import uk.co.boombastech.kotlinweb.http.controllers.Controller
import uk.co.boombastech.kotlinweb.http.requests.HttpMethod
import javax.inject.Inject

class RouteFactory @Inject constructor(val routes: Routes, val injector: Injector) {

    fun find(path: String, method: HttpMethod) : Controller {
        return injector.getInstance(routes.find(path, method).java)
    }
}