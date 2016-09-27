package uk.co.boombastech.kotlinweb.http.routing

import uk.co.boombastech.kotlinweb.http.controllers.Controller
import uk.co.boombastech.kotlinweb.http.filters.Filter

class RequestHandler(val controller: Controller, val filters: List<Filter>)