package uk.co.boombastech.kotlinweb.http.marshallers

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.inject.Inject
import uk.co.boombastech.kotlinweb.http.config.Properties

class JsonMarshaller @Inject constructor(val properties: Properties) : Marshaller {
    override val defaultContentType: String = "application/json"

    val gson: Gson = GsonBuilder()
            .create()

    override fun shouldMarshall(contentType: String): Boolean {
        return properties.jsonMarshaller.contains(contentType)
    }

    override fun marshall(data: Any): String {
        return gson.toJson(data)
    }
}