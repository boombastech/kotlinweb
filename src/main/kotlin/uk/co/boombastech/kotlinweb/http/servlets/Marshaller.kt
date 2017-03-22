package uk.co.boombastech.kotlinweb.http.servlets

interface Marshaller {
    val defaultContentType: String

    fun shouldMarshall(contentType: String): Boolean
    fun marshall(data: Any): String
}