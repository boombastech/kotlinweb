package uk.co.boombastech.kotlinweb.http.servlets

import org.eclipse.jetty.websocket.servlet.WebSocketServlet
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory

class WebSocketServlet() : WebSocketServlet() {
    override fun configure(factory: WebSocketServletFactory) {
        throw UnsupportedOperationException("not implemented")
    }
}