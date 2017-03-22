package uk.co.boombastech.kotlinweb.http.servlets

import uk.co.boombastech.kotlinweb.http.DataResponse
import uk.co.boombastech.kotlinweb.http.Response
import uk.co.boombastech.kotlinweb.http.requests.Request
import javax.inject.Inject
import javax.servlet.http.HttpServletResponse

class ResponseRendererFactory @Inject constructor(private val dataResponseRenderer: DataResponseRenderer) {

    fun render(request: Request, response: Response, servletResponse: HttpServletResponse) {
        if (response is DataResponse) {
            dataResponseRenderer.render(request, response, servletResponse)
        }
    }
}