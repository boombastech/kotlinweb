package uk.co.boombastech.kotlinweb.http.requests

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class UrlTest {
    @Test fun findProtocol() {
        assertThat(Url("http://www.test-url.com:8080/hello/world?name=Test").protocol).isEqualTo("http")
    }

    @Test fun findHost() {
        assertThat(Url("http://www.test-url.com:8080/hello/world?name=Test").host).isEqualTo("www.test-url.com")
    }

    @Test fun findPort() {
        assertThat(Url("http://www.test-url.com:8080/hello/world?name=Test").port).isEqualTo(8080)
    }

    @Test fun findPortWhenNoneProvided() {
        assertThat(Url("http://www.test-url.com/hello/world?name=Test").port).isEqualTo(80)
    }

    @Test fun findPath() {
        assertThat(Url("http://www.test-url.com:8080/hello/world?name=Test").path).isEqualTo("/hello/world")
    }


    @Test fun findPathWhenRoot() {
        assertThat(Url("http://www.test-url.com:8080/?name=Test").path).isEqualTo("/")
    }

    @Test fun findQueryString() {
        assertThat(Url("http://www.test-url.com:8080/hello/world?name=Test").queryString).isEqualTo("name=Test")
    }

    @Test fun findQueryStringWhenNoneProvided() {
        assertThat(Url("http://www.test-url.com:8080/hello/world").queryString).isEqualTo("")
    }

    @Test fun findHash() {
        assertThat(Url("http://www.test-url.com:8080/hello/world#test").hash).isEqualTo("test")
    }

    @Test fun findHashWhenNoneProvided() {
        assertThat(Url("http://www.test-url.com:8080/hello/world").hash).isEqualTo("")
    }
}