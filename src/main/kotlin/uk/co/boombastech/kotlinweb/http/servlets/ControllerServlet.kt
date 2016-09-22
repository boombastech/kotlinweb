package uk.co.boombastech.kotlinweb.http.servlets

import uk.co.boombastech.kotlinweb.http.DataResponse
import uk.co.boombastech.kotlinweb.http.requests.HttpMethod
import uk.co.boombastech.kotlinweb.http.requests.RequestFactory
import uk.co.boombastech.kotlinweb.http.routing.RouteFactory
import javax.inject.Inject
import javax.inject.Singleton
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Singleton
class ControllerServlet @Inject constructor(private val routeFactory: RouteFactory, private val requestFactory: RequestFactory) : HttpServlet() {

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        // find correct controller
        val controller = routeFactory.find(req.requestURI, HttpMethod.valueOf(req.method))

        // call correct controller
        val response = controller.execute(requestFactory.get(req))

        // return result
        when(response) {
            is DataResponse -> resp.writer.print(response.data)
        }
    }
}

