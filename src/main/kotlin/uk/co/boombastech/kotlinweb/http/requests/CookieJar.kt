package uk.co.boombastech.kotlinweb.http.requests

class CookieJar(private val cookies: MutableList<Cookie>) {

    fun get(cookieName: CookieName): Cookie? {
        return cookies.firstOrNull { cookie -> cookie.name.equals(cookieName.name) && !cookie.deleted }
    }

    fun put(cookieName: CookieName, value: String, maxAge: Int = cookieName.maxAge, path: String = cookieName.path) {
        cookies.add(Cookie(cookieName.name, value, maxAge, true, path))
    }

    fun updated(): List<Cookie> {
        return cookies.filter { cookie -> cookie.modified || cookie.deleted }
    }
}