package com.light.sword

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class MainController {
    @GetMapping(value = ["/", ""])
    fun main(model: Model): ModelAndView {
        return ModelAndView("index")
    }

    @GetMapping(value = ["/open.html"])
    fun open(model: Model): ModelAndView {
        return ModelAndView("open")
    }
}
