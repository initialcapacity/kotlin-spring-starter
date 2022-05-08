package io.initialcapacity.starter

import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

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
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Welcome!")))
                .andExpect(
                    MockMvcResultMatchers.content()
                        .string(Matchers.containsString("Hi email@google.com, look like you have access to this page!"))
                )
        }
    }
}