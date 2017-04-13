package uk.co.boombastech.kotlinweb.http

import com.google.inject.AbstractModule
import uk.co.boombastech.kotlinweb.http.routing.Route
import uk.co.boombastech.kotlinweb.http.routing.Routes

abstract class WebModule : AbstractModule() {

    override fun configure() {
        wiring()
    }

    abstract fun getRoutes(): Routes

    fun getListOfRoutes(): List<Route> {
        return getRoutes().routes
    }

    open fun globalFilters(): GlobalFilters {
        return GlobalFilters()
    }

    open fun wiring() {}
}