package uk.co.boombastech.kotlinweb.http.marshallers

import com.google.inject.Injector
import uk.co.boombastech.kotlinweb.http.config.Properties
import javax.inject.Inject
import javax.inject.Provider

class MarshallerFactoryProvider @Inject constructor(injector: Injector, properties: Properties) : Provider<MarshallerFactory> {
    private val marshallerFactory: MarshallerFactory

    init {
        val defaultMarshaller = injector.getInstance(properties.defaultMarshaller.java)
        val marshallers = properties.marshallers.map { injector.getInstance(it.java) }

        marshallerFactory = MarshallerFactory(marshallers, defaultMarshaller)
    }

    override fun get(): MarshallerFactory {
        return marshallerFactory
    }
}