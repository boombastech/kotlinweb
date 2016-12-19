package uk.co.boombastech.kotlinweb.http.authentication

import com.google.inject.AbstractModule

class AuthenticationModule : AbstractModule() {
    override fun configure() {
        bind(AuthenticationFilter::class.java)
        bind(ActiveUserService::class.java).to(ActiveUserServiceImpl::class.java)
    }
}