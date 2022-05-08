package io.initialcapacity.starter

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Configuration
@EnableWebSecurity
class StarterSecurity : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(security: HttpSecurity) {
        security.httpBasic().disable()
    }
}