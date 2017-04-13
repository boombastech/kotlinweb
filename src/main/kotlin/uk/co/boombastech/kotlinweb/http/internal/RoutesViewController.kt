package uk.co.boombastech.kotlinweb.http.internal

import uk.co.boombastech.kotlinweb.http.DataResponse
import uk.co.boombastech.kotlinweb.http.Response
import uk.co.boombastech.kotlinweb.http.controllers.Controller
import uk.co.boombastech.kotlinweb.http.requests.HttpMethod
import uk.co.boombastech.kotlinweb.http.requests.Request
import uk.co.boombastech.kotlinweb.http.routing.Routes
import javax.inject.Inject

class RoutesViewController @Inject constructor(val routes: Routes) : Controller {

    override fun execute(request: Request): Response {
        val data = routes.routes

        return DataResponse(data.map { RouteView(it.path, it.controller.qualifiedName!!, it.method) })
    }
}

data class RouteView(val path: String, val controllerName : String, val httpMethod: HttpMethod)