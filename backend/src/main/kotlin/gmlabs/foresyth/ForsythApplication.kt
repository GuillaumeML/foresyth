package gmlabs.foresyth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ForsythApplication

fun main(args: Array<String>) {
    runApplication<ForsythApplication>(*args)
}
