package uk.co.boombastech.kotlinweb.http

import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.servlet.GuiceServletContextListener
import uk.co.boombastech.kotlinweb.http.config.Properties

class Listener(private val config: Properties) : GuiceServletContextListener() {

    override fun getInjector(): Injector {
        return Guice.createInjector(config.modules.map { it.java.getConstructor().newInstance() })
    }
}