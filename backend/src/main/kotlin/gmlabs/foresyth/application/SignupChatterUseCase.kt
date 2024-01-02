package gmlabs.foresyth.application

import gmlabs.foresyth.adapters.`in`.web.ChatterSignupRequest
import gmlabs.foresyth.adapters.`in`.web.mapToDomain
import gmlabs.foresyth.application.ports.out.SaveChatterPort
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignupChatterUseCase(
    val saveChatterPort: SaveChatterPort,
    val passwordEncoder: PasswordEncoder,
) {
    fun signupChatter(chatterSignupRequest: ChatterSignupRequest) {
        chatterSignupRequest.password = passwordEncoder.encode(chatterSignupRequest.password)
        saveChatterPort.saveChatter(chatterSignupRequest.mapToDomain())
    }
}
