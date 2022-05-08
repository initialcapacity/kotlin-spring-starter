package io.initialcapacity.starter

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class IndexController {
    @GetMapping(path = ["/"], produces = ["text/html"])
    fun unsecure(): ModelAndView {
        val authentication = authentication()
        val response = getEmail(authentication)
        return ModelAndView("index", response)
    }

    fun getEmail(authentication: Any): Map<String, Any?> {
        return mapOf("email" to authentication)
    }

    private fun authentication(): Any {
        return "email@google.com"
    }
}