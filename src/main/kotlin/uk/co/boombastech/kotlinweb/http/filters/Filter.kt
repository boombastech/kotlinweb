package uk.co.boombastech.kotlinweb.http.filters

import uk.co.boombastech.kotlinweb.http.requests.Request

interface Filter

interface PreControllerFilter : Filter {
    fun preControllerFilter(request: Request)
}

interface PostControllerFilter : Filter {
    fun postControllerFilter(request: Request)
}

interface PostResponseFilter : Filter {
    fun postResponseFilter(request: Request)
}