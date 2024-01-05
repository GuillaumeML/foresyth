package gmlabs.foresyth.application

import com.ninjasquad.springmockk.MockkBean
import gmlabs.foresyth.application.ports.out.SaveAuthorityPort
import gmlabs.foresyth.application.ports.out.SaveChatterPort
import gmlabs.foresyth.domain.Chatter
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.just
import io.mockk.runs
import org.springframework.security.crypto.password.PasswordEncoder

class RegisterChatterUseCaseTest : DescribeSpec() {
    // override fun extensions() = listOf(SpringExtension)

    @MockkBean
    lateinit var saveChatterPort: SaveChatterPort

    @MockkBean
    lateinit var saveAuthorityPort: SaveAuthorityPort

    @MockkBean
    lateinit var passwordEncoder: PasswordEncoder

    init {

        describe("RegisterChatterUseCase") {
            val chatter = createChatter()
            every { saveChatterPort.saveChatter(chatter) } just runs
            describe("") {
                it("should ") {
                }
            }
        }
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
