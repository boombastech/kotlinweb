package uk.co.boombastech.kotlinweb.http.requests

import javax.servlet.http.HttpServletRequest

class RequestFactory() {
    fun get(servletRequest: HttpServletRequest): Request {
        return HttpServletRequestImpl(servletRequest)
    }
}