package gmlabs.foresyth.adapters.`in`.web

import gmlabs.foresyth.application.SignupChatterUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class SignupController(private val signupChatterUseCase: SignupChatterUseCase) {
    @PostMapping("/signup")
    fun registerUser(
        @RequestBody chatterSignupRequest: ChatterSignupRequest,
    ): ResponseEntity<Any> {
        signupChatterUseCase.signupChatter(chatterSignupRequest)
        return ResponseEntity.ok("User registered successfully")
    }
}
