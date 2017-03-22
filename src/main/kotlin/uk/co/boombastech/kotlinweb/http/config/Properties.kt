package uk.co.boombastech.kotlinweb.http.config

import com.google.inject.AbstractModule
import uk.co.boombastech.kotlinweb.http.internal.InternalModule
import uk.co.boombastech.kotlinweb.http.servlets.JsonMarshaller
import uk.co.boombastech.kotlinweb.http.servlets.Marshaller
import uk.co.boombastech.kotlinweb.http.servlets.XmlMarshaller
import kotlin.reflect.KClass

open class Properties {
    open val port: Int = 8080
    open val contextPath: String = "/"
    open val modules: List<KClass<out AbstractModule>> = listOf(ConfigModule::class, InternalModule::class)
    open val jsonMarshaller: List<String> = listOf("application/json", "application/json;v=2")
    open val xmlMarshaller: List<String> = listOf("application/xml")
    open val marshallers: List<KClass<out Marshaller>> = listOf(JsonMarshaller::class, XmlMarshaller::class)
    open val defaultMarshaller: KClass<out Marshaller> = JsonMarshaller::class
}