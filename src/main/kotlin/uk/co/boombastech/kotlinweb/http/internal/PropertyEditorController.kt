package uk.co.boombastech.kotlinweb.http.internal

import uk.co.boombastech.kotlinweb.http.DataResponse
import uk.co.boombastech.kotlinweb.http.Response
import uk.co.boombastech.kotlinweb.http.config.Properties
import uk.co.boombastech.kotlinweb.http.controllers.Controller
import uk.co.boombastech.kotlinweb.http.requests.Request
import javax.inject.Inject
import kotlin.reflect.KMutableProperty
import kotlin.reflect.declaredMemberProperties

class PropertyEditorController @Inject constructor(private val properties: Properties) : Controller {
    override fun execute(request: Request): Response {
        if (request.parameters.contains("key") && request.parameters.contains("value")) {
            val key = request.parameters.get("key")[0]
            val value = request.parameters.get("value")[0]

            val property = properties.javaClass.kotlin.declaredMemberProperties.filter { it.name.equals(key) }.first()
            if (property is KMutableProperty<*>) {
                property.setter.call(properties, value)
            }
        }

        return DataResponse("success")
    }
}