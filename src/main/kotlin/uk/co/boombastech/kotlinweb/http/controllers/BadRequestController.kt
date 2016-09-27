package uk.co.boombastech.kotlinweb.http.controllers

import uk.co.boombastech.kotlinweb.http.DataResponse
import uk.co.boombastech.kotlinweb.http.Response
import uk.co.boombastech.kotlinweb.http.requests.Request

class BadRequestController : Controller {
    override fun execute(request: Request): Response {
        return DataResponse("bad request")
    }
}