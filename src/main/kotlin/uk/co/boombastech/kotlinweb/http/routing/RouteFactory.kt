package uk.co.boombastech.kotlinweb.http.routing

import com.google.inject.Injector
import uk.co.boombastech.kotlinweb.http.controllers.Controller
import uk.co.boombastech.kotlinweb.http.requests.Request
import javax.inject.Inject

class RouteFactory @Inject constructor(val routes: Routes, val injector: Injector) {

    fun find(request: Request): Controller {
        return injector.getInstance(routes.find(request).java)
    }
}