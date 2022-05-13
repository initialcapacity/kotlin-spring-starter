package io.initialcapacity.starter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.access.vote.UnanimousBased
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class StarterSecurity(val appDecisionVoter: StarterSecurityDecisionVoter) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(security: HttpSecurity) {
        security.authorizeRequests().anyRequest().authenticated()
            .accessDecisionManager(UnanimousBased(listOf(appDecisionVoter)))
            .and()
            .exceptionHandling().authenticationEntryPoint { request, response, _ ->
                response.sendRedirect(request.getContextPath() + "/access-denied")
            }
        security.csrf().disable()
        security.httpBasic().disable()
    }
}
