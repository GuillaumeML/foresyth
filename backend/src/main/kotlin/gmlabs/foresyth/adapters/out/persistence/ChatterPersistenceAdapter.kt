package gmlabs.foresyth.adapters.out.persistence

import gmlabs.foresyth.application.ports.out.GetChattersPort
import org.springframework.stereotype.Component

@Component
class ChatterPersistenceAdapter(
    private val chatterRepository: ChatterRepository
): GetChattersPort {
    override fun getChatters(): List<ChatterEntity> {
        return chatterRepository.findAll()
    }
}