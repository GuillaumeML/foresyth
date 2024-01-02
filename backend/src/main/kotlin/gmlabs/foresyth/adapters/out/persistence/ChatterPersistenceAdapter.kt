package gmlabs.foresyth.adapters.out.persistence

import gmlabs.foresyth.application.ports.out.GetChattersPort
import gmlabs.foresyth.application.ports.out.SaveChatterPort
import gmlabs.foresyth.domain.Chatter
import org.springframework.stereotype.Component

@Component
class ChatterPersistenceAdapter(
    private val chatterRepository: ChatterRepository,
) : GetChattersPort, SaveChatterPort {
    override fun getChatters(): List<ChatterEntity> {
        return chatterRepository.findAll()
    }

    override fun saveChatter(chatter: Chatter) {
        chatterRepository.save(chatter.mapToEntity())
    }
}
