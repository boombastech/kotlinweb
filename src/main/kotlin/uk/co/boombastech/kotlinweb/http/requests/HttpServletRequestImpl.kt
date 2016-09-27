package uk.co.boombastech.kotlinweb.http.requests

import javax.servlet.http.HttpServletRequest

class HttpServletRequestImpl(private val httpServlet: HttpServletRequest) : Request {
    override val cookies: CookieJar by lazy {

        val mutableListOf = mutableListOf<Cookie>()

        if (httpServlet.cookies != null) {
            for (cookie in httpServlet.cookies) {
                mutableListOf.add(Cookie(cookie.name, cookie.value))
            }
        }

        CookieJar(mutableListOf)
    }

    override val url: Url by lazy {
        Url(httpServlet.requestURI)
    }

    override val method: HttpMethod by lazy {
        HttpMethod.valueOf(httpServlet.method)
    }

    override val parameters: Parameters by lazy {
        val parameterMap = mutableMapOf<String, List<String>>()

        val parameterNames = httpServlet.parameterNames.toList()

        parameterNames.forEach { name ->
            parameterMap.put(name, httpServlet.getParameterValues(name).toList())
        }

        Parameters(parameterMap)
    }

    override val headers: Headers by lazy {
        val headerMap = mutableMapOf<String, List<String>>()

        val headerNames = httpServlet.headerNames.toList()

        headerNames.forEach { name ->
            headerMap.put(name, httpServlet.getHeaders(name).toList())
        }

        Headers(headerMap)
    }
}