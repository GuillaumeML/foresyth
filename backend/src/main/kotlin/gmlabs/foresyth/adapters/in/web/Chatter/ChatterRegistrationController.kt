package gmlabs.foresyth.adapters.`in`.web.Chatter

import gmlabs.foresyth.application.SignupChatterUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ChatterRegistrationController(
    private val signupChatterUseCase: SignupChatterUseCase,
) {
    @PostMapping("/register")
    fun registerUser(
        @RequestBody chatterRegistrationRequest: ChatterRegistrationRequest,
    ): ResponseEntity<Any> {
        signupChatterUseCase.signupChatter(chatterRegistrationRequest)
        return ResponseEntity.ok("User registered successfully")
    }
}
