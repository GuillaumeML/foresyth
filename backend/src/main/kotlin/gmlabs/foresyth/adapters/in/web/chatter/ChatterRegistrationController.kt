package gmlabs.foresyth.adapters.`in`.web.chatter

import gmlabs.foresyth.application.RegisterChatterUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ChatterRegistrationController(
    private val registerChatterUseCase: RegisterChatterUseCase,
) {
    @PostMapping("/register")
    fun registerUser(
        @RequestBody chatterRegistrationRequest: ChatterRegistrationRequest,
    ): ResponseEntity<Any> {
        registerChatterUseCase.registerChatter(chatterRegistrationRequest)
        return ResponseEntity.ok("User registered successfully")
    }
}
