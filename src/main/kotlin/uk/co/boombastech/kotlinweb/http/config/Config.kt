package uk.co.boombastech.kotlinweb.http.config

import com.natpryce.konfig.*
import uk.co.boombastech.kotlinweb.http.config.Config.server.port

class Config {

    object server : PropertyGroup() {
        val port by intType
        val modules by stringType
    }

    private val configuration : Configuration

    init {
        configuration = EnvironmentVariables() overriding
                ConfigurationProperties.fromResource("kotlinweb.properties")
    }
    fun <T> getProperty(key: Key<T>) : T {
        return configuration[key]
    }
}

fun main(args: Array<String>) {
    val config = Config()
    println(config.getProperty(port))
}