package io.initialcapacity.starter

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class IndexController {
    @GetMapping(path = ["/"], produces = ["text/html"])
    fun unsecure(): ModelAndView {
        return ModelAndView("index", mapOf<String, Any>("email" to "sales@hexaindustries.io"))
    }
}