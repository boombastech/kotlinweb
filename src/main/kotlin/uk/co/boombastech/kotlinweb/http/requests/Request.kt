package uk.co.boombastech.kotlinweb.http.requests

interface Request {
    fun url() : String
    fun method() : HttpMethod
    fun parameters(): Parameters
}