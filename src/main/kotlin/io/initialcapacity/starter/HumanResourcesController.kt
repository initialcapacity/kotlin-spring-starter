package io.initialcapacity.starter

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class HumanResourcesController {
    @GetMapping(path = ["/humanresources"], produces = ["text/html"])
    fun unsecure(): ModelAndView {
        return ModelAndView("humanresources", mapOf<String, Any>("email" to "sales@hexaindustries.io"))
    }
}