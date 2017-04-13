package uk.co.boombastech.kotlinweb.http

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.servlet.GuiceServletContextListener
import com.google.inject.servlet.ServletModule
import uk.co.boombastech.kotlinweb.http.config.Properties
import uk.co.boombastech.kotlinweb.http.filters.Filter
import uk.co.boombastech.kotlinweb.http.marshallers.MarshallerFactory
import uk.co.boombastech.kotlinweb.http.marshallers.MarshallerFactoryProvider
import uk.co.boombastech.kotlinweb.http.requests.RequestFactory
import uk.co.boombastech.kotlinweb.http.routing.Route
import uk.co.boombastech.kotlinweb.http.routing.RouteFactory
import uk.co.boombastech.kotlinweb.http.routing.Routes
import uk.co.boombastech.kotlinweb.http.servlets.ControllerServlet
import kotlin.reflect.KClass

class Listener(private val config: Properties) : GuiceServletContextListener() {

    override fun getInjector(): Injector {
        val modules = config.modules.map { it.java.getConstructor().newInstance() }
        val routes: List<Route> = modules.filter { it is WebModule }.map { webModule -> webModule as WebModule }.flatMap(WebModule::getListOfRoutes)
        val globalFilters: List<KClass<out Filter>> = modules.filter { it is WebModule }.map { webModule -> webModule as WebModule }.flatMap { it.globalFilters().filters }

        val routesModule = RoutesModule(routes, GlobalFilters(globalFilters))

        val mutableListOf: MutableList<AbstractModule> = mutableListOf()
        mutableListOf.addAll(modules)
        mutableListOf.add(routesModule)

        return Guice.createInjector(mutableListOf)
    }
}

class RoutesModule(val routes: List<Route>, val globalFilters: GlobalFilters) : ServletModule() {
    override fun configureServlets() {
        bind(Routes::class.java).toInstance(Routes(routes))
        bind(GlobalFilters::class.java).toInstance(globalFilters)
        bind(RequestFactory::class.java)
        bind(RouteFactory::class.java)
        bind(GlobalFiltersFactory::class.java)
        bind(MarshallerFactory::class.java).toProvider(MarshallerFactoryProvider::class.java)

        serve("*").with(ControllerServlet::class.java)
    }

}
