package uk.co.boombastech.kotlinweb.http.controllers

import uk.co.boombastech.kotlinweb.http.Response
import uk.co.boombastech.kotlinweb.http.requests.Request

interface Controller {
    fun execute(request: Request): Response
}