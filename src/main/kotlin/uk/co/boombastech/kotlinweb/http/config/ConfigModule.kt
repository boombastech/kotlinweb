package uk.co.boombastech.kotlinweb.http.config

import com.google.inject.AbstractModule

class ConfigModule : AbstractModule() {
    override fun configure() {
        bind(Properties::class.java).toInstance(createProperties())
    }
}