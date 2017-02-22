package uk.co.boombastech.kotlinweb.http.filters

import uk.co.boombastech.kotlinweb.http.Response
import uk.co.boombastech.kotlinweb.http.requests.Request

interface PostResponseFilter : Filter {
    fun postResponseFilter(request: Request, response: Response)
}