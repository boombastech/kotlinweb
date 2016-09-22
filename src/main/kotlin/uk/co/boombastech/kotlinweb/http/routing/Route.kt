package uk.co.boombastech.kotlinweb.http.routing

import uk.co.boombastech.kotlinweb.http.controllers.Controller
import uk.co.boombastech.kotlinweb.http.requests.HttpMethod
import kotlin.reflect.KClass

class Route(val path: String, val method: HttpMethod, val controller: KClass<out Controller>)