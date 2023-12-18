package gmlabs.forsyth.adapters.`in`.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

//Runs locally on http://localhost:8080/
@RestController
class UserController {
    @GetMapping("/users")
    fun getUsers(): String {
        return "GML"
    }
}