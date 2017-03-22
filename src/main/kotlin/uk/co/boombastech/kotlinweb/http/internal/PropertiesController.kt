package uk.co.boombastech.kotlinweb.http.internal

import uk.co.boombastech.kotlinweb.http.DataResponse
import uk.co.boombastech.kotlinweb.http.Response
import uk.co.boombastech.kotlinweb.http.config.Properties
import uk.co.boombastech.kotlinweb.http.controllers.Controller
import uk.co.boombastech.kotlinweb.http.requests.Request
import javax.inject.Inject
import kotlin.reflect.KMutableProperty
import kotlin.reflect.declaredMemberProperties

class PropertiesController @Inject constructor(val properties: Properties) : Controller {

    override fun execute(request: Request): Response {
        return DataResponse(this.properties.javaClass.kotlin.declaredMemberProperties.map { memberProperty ->
            val name = memberProperty.name
            val rawValue = memberProperty.get(this.properties)
            val editable = memberProperty is KMutableProperty<*>

            if (rawValue is Collection<*>) {
                PropertyView(name, rawValue.map(Any?::toString), editable)
            } else {
                PropertyView(name, rawValue.toString(), editable)
            }
        })
    }
}