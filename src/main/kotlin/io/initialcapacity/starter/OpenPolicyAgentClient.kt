package io.initialcapacity.starter

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class OpenPolicyAgentClient {
    @Value("\${opa.server.url}")
    private var opaServerUrl: String = "http://localhost:8881/v1/data/authz/allow"

    fun allowFor(input: OpenPolicyAgentInput): Boolean {
        val mapper = ObjectMapper().registerKotlinModule()
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        val template = RestTemplate()
        val response = template.exchange(
            "$opaServerUrl",
            HttpMethod.POST,
            HttpEntity(mapper.writeValueAsString(input)),
            String::class.java
        )
        val decision = mapper.readValue(response.body, OpenPolicyAgentDecision::class.java)
        return decision.result
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class OpenPolicyAgentDecision(val result: Boolean)