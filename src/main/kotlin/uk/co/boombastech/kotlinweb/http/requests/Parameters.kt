package uk.co.boombastech.kotlinweb.http.requests

class Parameters(private val parameters: Map<String, List<String>>) {

    fun contains(key: String) :Boolean {
        return parameters.containsKey(key)
    }

    fun get(key: String) :List<String>{
        return parameters.getOrElse(key) { listOf() }
    }
}