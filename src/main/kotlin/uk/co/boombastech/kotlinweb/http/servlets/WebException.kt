package uk.co.boombastech.kotlinweb.http.servlets

import uk.co.boombastech.kotlinweb.http.DataResponse
import uk.co.boombastech.kotlinweb.http.Response
import uk.co.boombastech.kotlinweb.http.requests.Request

open class WebException : Exception() {

    open fun execute(request: Request): Response {
        return DataResponse("Exception thrown")
    }
}