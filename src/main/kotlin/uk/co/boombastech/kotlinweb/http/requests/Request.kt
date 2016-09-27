package uk.co.boombastech.kotlinweb.http.requests

interface Request {
    val url: Url
    val method: HttpMethod
    val parameters: Parameters
    val headers: Headers
}