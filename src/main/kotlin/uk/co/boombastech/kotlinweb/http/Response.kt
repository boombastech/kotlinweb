package uk.co.boombastech.kotlinweb.http

import uk.co.boombastech.kotlinweb.http.HttpStatus.ok

abstract class Response(val httpStatus: HttpStatus = ok, val headers: MutableMap<String, String> = mutableMapOf())