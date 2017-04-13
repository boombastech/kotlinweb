package uk.co.boombastech.kotlinweb.http

import uk.co.boombastech.kotlinweb.http.filters.Filter
import kotlin.reflect.KClass

class GlobalFilters(val filters: List<KClass<out Filter>>) {
    constructor(vararg filter: KClass<out Filter>) : this(filter.toList())
}