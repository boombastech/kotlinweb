package uk.co.boombastech.kotlinweb.http

enum class HttpStatus(val code: Int) {
    ok(200),
    created(201),
    accepted(202),
    noContent(204),
    badRequest(400)
}