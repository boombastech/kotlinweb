package uk.co.boombastech.kotlinweb.http.requests

class Url(val url: String) {

    val protocol: String by lazy {
        url.substringBefore("://", "http")
    }

    val host: String by lazy {
        val minusProtocol = url.substringAfter("://")
        minusProtocol.toRegex()
        val hostPotentiallyWithPort = minusProtocol.substringBefore("/")
        hostPotentiallyWithPort.substringBefore(":", hostPotentiallyWithPort)
    }

    val port: Int by lazy {
        val minusProtocol = url.substringAfter("://")
        val hostPotentiallyWithPort = minusProtocol.substringBefore("/")
        hostPotentiallyWithPort.substringAfter(":", "80").toInt()
    }

    val path: String by lazy {
        val minusProtocol = url.substringAfter("://")
        "/" + minusProtocol.substringAfter("/").substringBefore("?")
    }

    val queryString: String by lazy {
        url.substringAfter("?", "")
    }

    val hash: String by lazy {
        url.substringAfter("#", "")
    }

    override fun toString(): String {
        return url
    }
}