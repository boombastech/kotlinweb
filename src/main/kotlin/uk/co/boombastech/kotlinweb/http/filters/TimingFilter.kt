package uk.co.boombastech.kotlinweb.http.filters

import uk.co.boombastech.kotlinweb.http.requests.Request

class TimingFilter : PostResponseFilter {
    val startTime: Long = System.currentTimeMillis()

    override fun postResponseFilter(request: Request) {
        val endTime = System.currentTimeMillis()

        println("Request took: " + (endTime - startTime) + "ms")
    }
}