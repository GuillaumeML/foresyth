package gmlabs.foresyth.application

import gmlabs.foresyth.adapters.`in`.web.ChatterSignupRequest
import gmlabs.foresyth.application.ports.out.SaveChatterPort
import gmlabs.foresyth.domain.Chatter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignupChatterUseCase(
    val saveChatterPort: SaveChatterPort,
    val passwordEncoder: PasswordEncoder,
) {
    fun signupChatter(chatterSignupRequest: ChatterSignupRequest) {
        val chatter =
            Chatter(
                username = chatterSignupRequest.chatterName,
                password = passwordEncoder.encode(chatterSignupRequest.password),
                enabled = true,
            )
        saveChatterPort.saveChatter(chatter)
    }
}
