import com.ninjasquad.springmockk.MockkBean
import gmlabs.foresyth.ForsythApplication
import gmlabs.foresyth.adapters.`in`.web.WebSecurityConfiguration
import gmlabs.foresyth.adapters.`in`.web.chatter.ChatterController
import gmlabs.foresyth.application.GetChattersQuery
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.mockk.every
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.RequestPostProcessor
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@WebMvcTest(ChatterController::class)
@ContextConfiguration(classes = [ForsythApplication::class, WebSecurityConfiguration::class])
@WebAppConfiguration
class ChatterControllerGetAllTest : DescribeSpec() {
    override fun extensions() = listOf(SpringExtension)

    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerTest

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var context: WebApplicationContext

    @MockkBean
    lateinit var getChattersQuery: GetChattersQuery

    init {

        beforeEach {
            fun setup() {
                mockMvc = MockMvcBuilders.webAppContextSetup(context).apply<DefaultMockMvcBuilder?>(springSecurity()).build()
            }
        }

        describe("GET /chatters") {
            every { getChattersQuery.getChatters() } returns emptyList()

            describe("when user is authorized with a known role") {
                it("should return 200 OK") {
                    getChatters(createChatterWithRoleUser())
                        .andExpect(status().isOk)
                }
            }

            describe("when user is not authorized") {
                it("should return 401") {
                    getChatters(anonymous())
                        .andExpect(status().isUnauthorized)
                }
            }
        }
    }

    private fun createChatterWithRoleUser(): RequestPostProcessor = user("user").password("pass").roles("USER")
    private fun getChatters(user: RequestPostProcessor) = mockMvc
        .perform(
            get("/chatters")
                .with(
                    user
                )
                .contentType(MediaType.APPLICATION_JSON),
        )

}
