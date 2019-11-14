package com.light.sword

import groovy.lang.GroovySystem
import org.springframework.boot.SpringBootVersion
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class MainController {
    @GetMapping(value = ["/", ""])
    fun main(model: Model): ModelAndView {
        model.addAttribute("bootVersion", SpringBootVersion.getVersion())
        model.addAttribute("groovyVersion", GroovySystem.getVersion())
        return ModelAndView("index")
    }

    @GetMapping(value = ["/open.html"])
    fun open(model: Model): ModelAndView {
        return ModelAndView("open")
    }
}
