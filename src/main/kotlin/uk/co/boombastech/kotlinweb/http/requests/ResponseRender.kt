package uk.co.boombastech.kotlinweb.http.requests

import uk.co.boombastech.kotlinweb.http.Response
import javax.servlet.http.HttpServletResponse

interface ResponseRender<in T : Response> {
    fun render(request: Request, response: T, servletResponse: HttpServletResponse)
}