package uk.co.boombastech.kotlinweb.http.servlets

import com.google.inject.Inject
import uk.co.boombastech.kotlinweb.http.config.Properties

class XmlMarshaller @Inject constructor(val properties: Properties) : Marshaller {
    override val defaultContentType: String = "application/xml"

    override fun shouldMarshall(contentType: String): Boolean {
        return properties.xmlMarshaller.contains(contentType)
    }

    override fun marshall(data: Any): String {
        return data.toString()
    }
}