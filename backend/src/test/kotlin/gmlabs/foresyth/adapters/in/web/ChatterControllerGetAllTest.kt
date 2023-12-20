
import gmlabs.foresyth.ForsythApplication
import gmlabs.foresyth.adapters.`in`.web.ChatterController
import gmlabs.foresyth.application.GetChattersQuery
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(ChatterController::class)
@ContextConfiguration(classes = [ForsythApplication::class])
class ChatterControllerGetAllTest : DescribeSpec() {
    override fun extensions() = listOf(SpringExtension)

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var getChattersQuery: GetChattersQuery

    init {

        describe("GET /chatters") {
            Mockito.`when`(getChattersQuery.getChatters()).thenReturn(emptyList())
            it("should return 200 OK") {
                mockMvc.perform(get("/chatters").contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk)
            }
        }
    }
}