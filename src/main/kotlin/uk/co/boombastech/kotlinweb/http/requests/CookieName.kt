package uk.co.boombastech.kotlinweb.http.requests

interface CookieName {
    val name: String
    val path: String
        get() = "/"
    val maxAge: Int
        get() = -1

}