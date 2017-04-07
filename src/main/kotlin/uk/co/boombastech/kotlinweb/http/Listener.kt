package uk.co.boombastech.kotlinweb.http

import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.servlet.GuiceServletContextListener
import uk.co.boombastech.kotlinweb.http.config.Properties

class Listener(private val config: Properties) : GuiceServletContextListener() {

    override fun getInjector(): Injector {
        val modules = config.modules.map { it.java.getConstructor().newInstance() }
        modules.forEach { module ->
            if (module is WebModule) {
                module.getRoutes()
            }
        }



        return Guice.createInjector(modules)
    }
}