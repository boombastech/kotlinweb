package uk.co.boombastech.kotlinweb.http.requests

import javax.servlet.http.HttpServletRequest

class HttpServletRequestImpl(val httpServlet: HttpServletRequest) : Request {

    override fun url(): String {
        return httpServlet.requestURI
    }

    override fun method(): HttpMethod {
        return HttpMethod.valueOf(httpServlet.method)
    }

    override fun parameters(): Parameters {
        val parameterMap = mutableMapOf<String, List<String>>()

        val parameterNames = httpServlet.parameterNames.toList()

        parameterNames.forEach { name ->
            parameterMap.put(name, httpServlet.getParameterValues(name).toList())
        }

        return Parameters(parameterMap)
    }

    fun headers(): Headers {
        val headerMap = mutableMapOf<String, List<String>>()

        val headerNames = httpServlet.headerNames.toList()

        headerNames.forEach { name ->
            headerMap.put(name, httpServlet.getHeaders(name).toList())
        }

        return Headers(headerMap)
    }
}