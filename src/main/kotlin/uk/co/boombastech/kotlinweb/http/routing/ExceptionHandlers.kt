package uk.co.boombastech.kotlinweb.http.routing

import uk.co.boombastech.kotlinweb.http.DataResponse
import uk.co.boombastech.kotlinweb.http.Response
import uk.co.boombastech.kotlinweb.http.authentication.AuthenticationException
import uk.co.boombastech.kotlinweb.http.requests.Request

interface ExceptionHandler<in T : Exception> {
    fun handle(request: Request, exception: T): Response
}

class DefaultExceptionHandler : ExceptionHandler<Exception> {
    override fun handle(request: Request, exception: Exception): Response {
        throw UnsupportedOperationException("not implemented")
    }
}

class JunkExceptionHandler : ExceptionHandler<AuthenticationException> {
    override fun handle(request: Request, exception: AuthenticationException): Response {
        return DataResponse("Invalid user authentication")
    }
}