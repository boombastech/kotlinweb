package uk.co.boombastech.kotlinweb.http.servlets

import uk.co.boombastech.kotlinweb.http.DataResponse
import uk.co.boombastech.kotlinweb.http.GlobalFilters
import uk.co.boombastech.kotlinweb.http.GlobalFiltersFactory
import uk.co.boombastech.kotlinweb.http.filters.PostControllerFilter
import uk.co.boombastech.kotlinweb.http.filters.PreControllerFilter
import uk.co.boombastech.kotlinweb.http.requests.RequestFactory
import uk.co.boombastech.kotlinweb.http.routing.RouteFactory
import javax.inject.Inject
import javax.inject.Singleton
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Singleton
class ControllerServlet @Inject constructor(private val routeFactory: RouteFactory, private val requestFactory: RequestFactory, private val globalFilters: GlobalFiltersFactory) : HttpServlet() {

    override fun service(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse) {
        val request = requestFactory.get(servletRequest)

        val requestHandler = routeFactory.find(request)

        globalFilters.getFilters().filterIsInstance(PreControllerFilter::class.java).forEach { filter -> filter.preControllerFilter(request) }
        requestHandler.filters.filterIsInstance(PreControllerFilter::class.java).forEach { filter -> filter.preControllerFilter(request) }

        val response = requestHandler.controller.execute(request)

        globalFilters.getFilters().filterIsInstance(PostControllerFilter::class.java).forEach { filter -> filter.postControllerFilter(request) }
        requestHandler.filters.filterIsInstance(PostControllerFilter::class.java).forEach { filter -> filter.postControllerFilter(request) }

        request.cookies.updated().forEach({ cookie ->
            servletResponse.addCookie(cookie.toServletCookie())
        })

        when (response) {
            is DataResponse -> servletResponse.writer.print(response.data)
        }

        globalFilters.getFilters().filterIsInstance(PreControllerFilter::class.java).forEach { filter -> filter.preControllerFilter(request) }
        requestHandler.filters.filterIsInstance(PreControllerFilter::class.java).forEach { filter -> filter.preControllerFilter(request) }
    }
}

