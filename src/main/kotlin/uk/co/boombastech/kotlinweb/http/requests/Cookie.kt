package uk.co.boombastech.kotlinweb.http.requests

import javax.servlet.http.Cookie

class Cookie(val name: String, var value: String, var maxAge: Int = -1, val path: String = "/", var modified: Boolean = false) {
    var deleted: Boolean = false

    fun delete() {
        maxAge = 0
        deleted = true
    }

    fun toServletCookie(): Cookie {
        val cookie = Cookie(name, value)
        cookie.maxAge = maxAge
        cookie.path = path
        return cookie
    }
}