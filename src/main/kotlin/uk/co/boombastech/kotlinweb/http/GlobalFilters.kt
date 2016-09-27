package uk.co.boombastech.kotlinweb.http

import uk.co.boombastech.kotlinweb.http.filters.Filter
import kotlin.reflect.KClass

class GlobalFilters(vararg filter: KClass<out Filter>) {
    val filters: List<KClass<out Filter>> = filter.toList()
}