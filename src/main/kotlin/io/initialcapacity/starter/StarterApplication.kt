package io.initialcapacity.starter

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StarterApplication

fun main(args: Array<String>) {
    runApplication<StarterApplication>(*args) { setBannerMode(Banner.Mode.OFF) }
}
