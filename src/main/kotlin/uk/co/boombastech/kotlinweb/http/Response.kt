package uk.co.boombastech.kotlinweb.http

import uk.co.boombastech.kotlinweb.http.HttpStatus.ok

abstract class Response(val httpStatus: HttpStatus = ok, val headers: MutableMap<String,String> = mutableMapOf())

enum class HttpStatus(val code: Int) {
    ok(200),
    created(201),
    accepted(202),
    noContent(204),
    badRequest(400)
}