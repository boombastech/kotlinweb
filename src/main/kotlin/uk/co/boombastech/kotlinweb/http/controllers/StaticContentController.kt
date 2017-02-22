package uk.co.boombastech.kotlinweb.http.controllers

import uk.co.boombastech.kotlinweb.http.DataResponse
import uk.co.boombastech.kotlinweb.http.Response
import uk.co.boombastech.kotlinweb.http.requests.Request

class StaticContentController : Controller {
    override fun execute(request: Request): Response {
        throw UnsupportedOperationException("not implemented")
//        StaticContentController::class.java.classLoader.
        return DataResponse("static content")
    }
}