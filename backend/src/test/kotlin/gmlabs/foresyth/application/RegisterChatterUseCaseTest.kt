package gmlabs.foresyth.application

import gmlabs.foresyth.adapters.`in`.web.chatter.ChatterRegistrationRequest
import gmlabs.foresyth.application.ports.out.SaveAuthorityPort
import gmlabs.foresyth.application.ports.out.SaveChatterPort
import gmlabs.foresyth.domain.Authority
import gmlabs.foresyth.domain.Chatter
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.*
import org.springframework.security.crypto.password.PasswordEncoder

class RegisterChatterUseCaseTest : DescribeSpec() {
    private val saveChatterPort: SaveChatterPort = mockk()

    private val saveAuthorityPort: SaveAuthorityPort = mockk()

    private val passwordEncoder: PasswordEncoder = mockk()

    private val registerChatterUseCase =
        RegisterChatterUseCase(
            saveChatterPort,
            saveAuthorityPort,
            passwordEncoder,
        )

    init {

        describe("RegisterChatterUseCase") {
            val chatterRegistrationRequest = createChatterRegistrationRequest("testchattername", "testpassword")
            val someEncryptedPassword = "someEncryptedPassword"
            val savedChatter = createChatter(username = chatterRegistrationRequest.chatterName, password = someEncryptedPassword)
            val authority = createAuthority(savedChatter)

            describe("when a new chatter registers") {
                every { passwordEncoder.encode(chatterRegistrationRequest.password) } returns someEncryptedPassword
                every { saveChatterPort.saveChatter(savedChatter) } just runs
                every { saveAuthorityPort.saveAuthority(authority) } just runs

                registerChatterUseCase.registerChatter(chatterRegistrationRequest)

                it("should encode the password") {
                    verify(exactly = 1) { passwordEncoder.encode(chatterRegistrationRequest.password) }
                }

                it("should save the chatter ") {
                    verify(exactly = 1) { saveChatterPort.saveChatter(savedChatter) }
                }

                it("should save the role USER in the authority") {
                    verify(exactly = 1) { saveAuthorityPort.saveAuthority(any()) }
                }
            }
        }
    }

    private fun createAuthority(chatter: Chatter): Authority {
        return Authority(chatter, authority = "ROLE_USER")
    }

    private fun createChatterRegistrationRequest(
        chatterName: String = "testChatter",
        password: String = "testPassword",
    ): ChatterRegistrationRequest {
        return ChatterRegistrationRequest(chatterName = chatterName, password = password)
    }

    private fun createChatter(
        username: String = "testusername",
        password: String = "testpassword",
        enabled: Boolean = true,
    ): Chatter {
        return Chatter(
            username,
            password,
            enabled,
        )
    }
}
