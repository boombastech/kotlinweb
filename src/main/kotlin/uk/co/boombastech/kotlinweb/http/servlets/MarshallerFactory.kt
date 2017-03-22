package uk.co.boombastech.kotlinweb.http.servlets

import javax.inject.Inject

class MarshallerFactory @Inject constructor(val marshallers: List<Marshaller>, val defaultMarshaller: Marshaller) {
    fun getMarshaller(type: String): MarshallerType {
        val marshallers = marshallers.filter { marshaller -> marshaller.shouldMarshall(type) }

        if (marshallers.isEmpty()) {
            return MarshallerType(defaultMarshaller, defaultMarshaller.defaultContentType)
        } else {
            val marshaller = marshallers[0]
            return MarshallerType(marshaller, type)
        }
    }
}

data class MarshallerType(val marshaller: Marshaller, val contentType: String)