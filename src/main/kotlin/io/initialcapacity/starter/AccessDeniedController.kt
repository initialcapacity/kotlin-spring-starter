package io.initialcapacity.starter

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class AccessDeniedController {
    @GetMapping(path = ["/access-denied"], produces = ["text/html"])
    fun unsecure(): ModelAndView {
        return ModelAndView("accessdenied")
    }
}