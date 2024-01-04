package gmlabs.foresyth.application

import gmlabs.foresyth.adapters.`in`.web.ChatterRegistrationRequest
import gmlabs.foresyth.application.ports.out.SaveChatterPort
import gmlabs.foresyth.domain.Chatter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignupChatterUseCase(
    val saveChatterPort: SaveChatterPort,
    val passwordEncoder: PasswordEncoder,
) {
    fun signupChatter(chatterRegistrationRequest: ChatterRegistrationRequest) {
        val chatter =
            Chatter(
                username = chatterRegistrationRequest.chatterName,
                password = passwordEncoder.encode(chatterRegistrationRequest.password),
                enabled = true,
            )
        saveChatterPort.saveChatter(chatter)
    }
}
