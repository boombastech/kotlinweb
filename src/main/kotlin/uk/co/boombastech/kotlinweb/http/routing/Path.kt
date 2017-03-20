package uk.co.boombastech.kotlinweb.http.routing

import uk.co.boombastech.kotlinweb.http.requests.Request

class Path(val path: String) {

    fun matches(request: Request): Boolean {
        return path == request.url.path
    }
}