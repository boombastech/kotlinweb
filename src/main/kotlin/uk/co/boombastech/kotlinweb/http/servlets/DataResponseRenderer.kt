package uk.co.boombastech.kotlinweb.http.servlets

import uk.co.boombastech.kotlinweb.http.DataResponse
import uk.co.boombastech.kotlinweb.http.requests.Request
import uk.co.boombastech.kotlinweb.http.requests.ResponseRender
import javax.inject.Inject
import javax.servlet.http.HttpServletResponse

class DataResponseRenderer @Inject constructor(val marshallerFactory: MarshallerFactory) : ResponseRender<DataResponse> {
    override fun render(request: Request, response: DataResponse, servletResponse: HttpServletResponse) {
        val requestedContentType = request.headers.get("Accept")[0]
        val marshaller = marshallerFactory.getMarshaller(requestedContentType)
        servletResponse.contentType = marshaller.contentType
        servletResponse.writer.print(marshaller.marshaller.marshall(response.data))
    }
}