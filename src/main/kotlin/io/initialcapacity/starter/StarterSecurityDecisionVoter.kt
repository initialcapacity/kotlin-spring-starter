package io.initialcapacity.starter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.AccessDecisionVoter
import org.springframework.security.access.ConfigAttribute
import org.springframework.security.core.Authentication
import org.springframework.security.web.FilterInvocation
import org.springframework.stereotype.Component

@Component
class StarterSecurityDecisionVoter(val openPolicyAgentClient: OpenPolicyAgentClient) :
    AccessDecisionVoter<FilterInvocation> {

    override fun supports(attribute: ConfigAttribute): Boolean {
        return true
    }

    override fun supports(clazz: Class<*>): Boolean {
        return true
    }

    override fun vote(
        authentication: Authentication, filter: FilterInvocation, attributes: MutableCollection<ConfigAttribute>
    ): Int {
        if (shouldNotFilter(filter.request.requestURI)) {
            return 1
        }
        val input =
            OpenPolicyAgentInput(
                listOf("allusers", "allauthenticatedusers", "sales@hexaindustries.io"),
                filter.request.method,
                filter.requestUrl
            )

        val response = openPolicyAgentClient.allowFor(input)
        return if (response) 1 else -1
    }

    private fun shouldNotFilter(path: String): Boolean {
        return path.startsWith("/favicon.svg")
                || path.startsWith("/favicon.ico")
                || path.startsWith("/reset.css")
                || path.startsWith("/style.css")
                || path.startsWith("/actuator")
                || path.startsWith("/access-denied")
    }
}