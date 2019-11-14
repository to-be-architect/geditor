package com.light.sword

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication
@ServletComponentScan(basePackages = ["com.mxgraph.online"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
