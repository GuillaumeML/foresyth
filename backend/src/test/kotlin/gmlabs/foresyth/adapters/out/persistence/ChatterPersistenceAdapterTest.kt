package gmlabs.foresyth.adapters.out.persistence

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles

@DataJpaTest
@ActiveProfiles("test") // Use the 'test' profile
class ChatterPersistenceAdapterTest(private val chatterRepository: ChatterRepository) : DescribeSpec() {
    val chatterPersistenceAdapter = ChatterPersistenceAdapter(chatterRepository)


    init {

        describe("ChatterPersistenceAdapter") {
            it("should retrieve chatters") {
                // Setup
                chatterPersistenceAdapter.getChatters()

                // Exercise
                val actualChatters = chatterRepository.findAll()

                // Verify
                actualChatters shouldBe emptyList()
            }
        }
    }
}
