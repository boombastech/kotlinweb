package uk.co.boombastech.kotlinweb.http.routing

import uk.co.boombastech.kotlinweb.http.controllers.Controller
import uk.co.boombastech.kotlinweb.http.filters.Filter
import uk.co.boombastech.kotlinweb.http.requests.HttpMethod
import kotlin.reflect.KClass

class Route(val path: String, val method: HttpMethod, val controller: KClass<out Controller>, vararg filter: KClass<out Filter>) {
    val filters: List<KClass<out Filter>> = filter.toList()
}