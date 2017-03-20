package uk.co.boombastech.kotlinweb.http.config

fun createProperties(): Properties {
    val propertyClassName = System.getProperty("properties")

    if (propertyClassName == null) {
        return Properties()
    } else {
        val clazz = Class.forName(propertyClassName)

        if (clazz is Properties) {
            return clazz
        } else {
            return Properties()
        }
    }
}