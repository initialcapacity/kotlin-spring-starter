package io.initialcapacity.starter

import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Import
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = ["spring.main.banner-mode=off", "opa.server.url="]
)
class StarterApplicationTests {
    @Autowired
    lateinit var template: TestRestTemplate

    @Test
    fun contextLoads() {
    }

    @Test
    fun actuator() {
        val entity = HttpEntity<String>(HttpHeaders())
        val response = template.exchange("/actuator/health", HttpMethod.GET, entity, String::class.java)

        AssertionsForClassTypes.assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        AssertionsForClassTypes.assertThat(response.body).contains("")
    }
}
