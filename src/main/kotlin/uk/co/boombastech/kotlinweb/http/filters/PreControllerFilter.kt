package uk.co.boombastech.kotlinweb.http.filters

import uk.co.boombastech.kotlinweb.http.requests.Request

interface PreControllerFilter : Filter {
    fun preControllerFilter(request: Request)
}