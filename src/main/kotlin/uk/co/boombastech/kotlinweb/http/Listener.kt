package uk.co.boombastech.kotlinweb.http

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.servlet.GuiceServletContextListener
import uk.co.boombastech.kotlinweb.http.config.Config

class Listener(private val config: Config) : GuiceServletContextListener() {

    override fun getInjector(): Injector {
        val module = config.getProperty(Config.server.modules)

        val clazz = Class.forName(module)
        val newInstance = clazz.getConstructor().newInstance()

        if (newInstance is AbstractModule) {
            return Guice.createInjector(ConfigModule(config), newInstance)
        } else {
            throw Exception("module supplied isn't a module")
        }
    }
}

class ConfigModule(val config: Config) : AbstractModule() {
    override fun configure() {
        bind(Config::class.java).toInstance(config)
    }

}