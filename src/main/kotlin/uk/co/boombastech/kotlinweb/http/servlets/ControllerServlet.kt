package uk.co.boombastech.kotlinweb.http.servlets

import uk.co.boombastech.kotlinweb.http.DataResponse
import uk.co.boombastech.kotlinweb.http.requests.RequestFactory
import uk.co.boombastech.kotlinweb.http.routing.RouteFactory
import javax.inject.Inject
import javax.inject.Singleton
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Singleton
class ControllerServlet @Inject constructor(private val routeFactory: RouteFactory, private val requestFactory: RequestFactory) : HttpServlet() {

    override fun service(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse) {
        val request = requestFactory.get(servletRequest)
        val controller = routeFactory.find(request)

        val response = controller.execute(request)

        request.cookies.updated().forEach({ cookie ->
            servletResponse.addCookie(cookie.toServletCookie())
        })

        when (response) {
            is DataResponse -> servletResponse.writer.print(response.data)
        }
    }
}

