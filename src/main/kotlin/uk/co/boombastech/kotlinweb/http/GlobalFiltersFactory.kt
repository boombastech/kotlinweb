package uk.co.boombastech.kotlinweb.http

import com.google.inject.Injector
import uk.co.boombastech.kotlinweb.http.filters.Filter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GlobalFiltersFactory @Inject constructor(private val globalFilters: GlobalFilters, private val injector: Injector) {

    fun getFilters(): List<Filter> {
        return globalFilters.filters.map { filter ->
            injector.getInstance(filter.java)
        }
    }
}