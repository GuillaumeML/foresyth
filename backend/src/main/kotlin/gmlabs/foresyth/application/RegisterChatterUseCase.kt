package gmlabs.foresyth.application

import gmlabs.foresyth.adapters.`in`.web.chatter.ChatterRegistrationRequest
import gmlabs.foresyth.application.ports.out.SaveAuthorityPort
import gmlabs.foresyth.application.ports.out.SaveChatterPort
import gmlabs.foresyth.domain.Authority
import gmlabs.foresyth.domain.Chatter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class RegisterChatterUseCase(
    val saveChatterPort: SaveChatterPort,
    val saveAuthorityPort: SaveAuthorityPort,
    val passwordEncoder: PasswordEncoder,
) {
    fun registerChatter(chatterRegistrationRequest: ChatterRegistrationRequest) {
        val chatter =
            Chatter(
                username = chatterRegistrationRequest.chatterName,
                password = passwordEncoder.encode(chatterRegistrationRequest.password),
                enabled = true
            )
        val authority =
            Authority(
                chatter = chatter,
                authority = "ROLE_USER"
            )
        saveChatterPort.saveChatter(chatter)
        saveAuthorityPort.saveAuthority(authority)
    }
}
