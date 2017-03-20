package uk.co.boombastech.kotlinweb.http.config

import com.google.inject.AbstractModule
import uk.co.boombastech.kotlinweb.http.internal.InternalModule
import kotlin.reflect.KClass

open class Properties {
    open val port: Int = 8080
    open val contextPath: String = "/"
    open val modules: List<KClass<out AbstractModule>> = listOf(ConfigModule::class, InternalModule::class)
    open var changeable: String = "original"
}