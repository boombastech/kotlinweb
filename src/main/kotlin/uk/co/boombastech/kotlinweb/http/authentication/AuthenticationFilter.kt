package uk.co.boombastech.kotlinweb.http.authentication

import uk.co.boombastech.kotlinweb.http.DataResponse
import uk.co.boombastech.kotlinweb.http.Response
import uk.co.boombastech.kotlinweb.http.filters.PreControllerFilter
import uk.co.boombastech.kotlinweb.http.requests.KotlinWebCookie.userId
import uk.co.boombastech.kotlinweb.http.requests.Request
import uk.co.boombastech.kotlinweb.http.servlets.WebException
import javax.inject.Inject

class AuthenticationFilter @Inject constructor(val activeUserService: ActiveUserService) : PreControllerFilter {

    override fun preControllerFilter(request: Request) {
        // look for a userId cookie
        val userIdCookie = request.cookies.get(userId)

        if (userIdCookie != null) {
            if (activeUserService.isActiveUser(userIdCookie.value)) {
                // good stuff
            } else {
                throw AuthenticationException("cannot find user")
            }
        } else {
            throw AuthenticationException("cannot find cookie")
        }
    }
}

class AuthenticationException(val s: String) : WebException() {
    override fun execute(request: Request): Response {
        return DataResponse(s)
    }
}