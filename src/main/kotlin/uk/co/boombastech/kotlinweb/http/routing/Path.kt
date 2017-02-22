package uk.co.boombastech.kotlinweb.http.routing

import uk.co.boombastech.kotlinweb.http.requests.Request

class Path(val path: String) {

    fun matches(request: Request): Boolean {
        return path == request.url.path
        // if the path contains {brackets} then there are path variables and we have to make sure we match them too.
//        val pathSegments = path.split("/")
//        val requestSegments = request.url.path.split("/")
//
//        if (pathSegments.size != requestSegments.size) {
//            return false;
//        }
//
//        val pathIterator = pathSegments.iterator()
//        val requestIterator = requestSegments.iterator()
//        val pathVariableIterator = pathVariables.iterator()
//
//        while (pathIterator.hasNext() && requestIterator.hasNext()) {
//            val pathSegment = pathIterator.next()
//            val requestSegment = requestIterator.next()
//
//            if (pathSegment.startsWith("{") && pathSegment.endsWith("}")) {
//                request
//
//            } else if (pathSegment != requestSegment) {
//                return false
//            }
//        }

    }
}