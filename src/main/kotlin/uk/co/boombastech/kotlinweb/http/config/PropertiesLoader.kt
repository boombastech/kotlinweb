package uk.co.boombastech.kotlinweb.http.config

fun createProperties(): Properties {
    val propertyClassName = System.getProperty("properties")

    if (propertyClassName == null) {
        return Properties()
    } else {
        val clazz = Class.forName(propertyClassName)
        val properties = clazz.getConstructor().newInstance()

        if (properties is Properties) {
            return properties
        } else {
            return Properties()
        }
    }
}