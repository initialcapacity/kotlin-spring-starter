package io.initialcapacity.starter

import io.mockk.every
import io.mockk.mockk
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


@TestConfiguration
class Voter {
    @Bean
    fun starterSecurityDecisionVoter(): StarterSecurityDecisionVoter {
        return mockk<StarterSecurityDecisionVoter>().apply {
            every { vote(any(), any(), any()) } returns 1
            every { supports(clazz = any()) } returns true
            every { supports(attribute = any()) } returns true
            println(this)
        }
    }
}

@Import(Voter::class)
@WebMvcTest(properties = ["spring.main.banner-mode=off"])
class IndexControllerTest {

    @Autowired
    lateinit var context: WebApplicationContext

    @Test
    fun index() {
        val mock = MockMvcBuilders
            .webAppContextSetup(context)
            .build()

        with(mock) {

            perform(
                MockMvcRequestBuilders.get("/")
            )
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(
                    MockMvcResultMatchers.content()
                        .string(Matchers.containsString("<p>Great news, you're able to access this page.</p>"))
                )
        }
    }
}