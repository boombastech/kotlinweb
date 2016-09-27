package uk.co.boombastech.kotlinweb.http.filters

import uk.co.boombastech.kotlinweb.http.requests.Request

interface PostControllerFilter : Filter {
    fun postControllerFilter(request: Request)
}