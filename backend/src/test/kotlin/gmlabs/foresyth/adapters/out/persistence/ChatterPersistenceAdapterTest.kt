package gmlabs.foresyth.adapters.out.persistence

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.util.*

@DataJpaTest
class ChatterPersistenceAdapterTest(
    private val chatterRepository: ChatterRepository,
) : DescribeSpec() {
    val chatterPersistenceAdapter = ChatterPersistenceAdapter(chatterRepository)

    init {
        describe("ChatterPersistenceAdapter") {
            it("should retrieve chatters") {
                val chatterEntity = ChatterEntity(username = "bob", password = "bob's password", enabled = true)
                chatterPersistenceAdapter.saveChatter(chatterEntity.mapToDomain())

                chatterPersistenceAdapter.getChatters()

                val actualChatters = chatterRepository.findAll()

                actualChatters.first().mapToDomain().username shouldBe "bob"
            }
        }
    }
}
