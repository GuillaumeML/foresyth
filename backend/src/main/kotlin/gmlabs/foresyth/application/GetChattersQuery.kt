package gmlabs.foresyth.application

import gmlabs.foresyth.adapters.out.persistence.mapToDomain
import gmlabs.foresyth.application.ports.out.GetChattersPort
import gmlabs.foresyth.domain.Chatter
import org.springframework.stereotype.Service

@Service
class GetChattersQuery(
    val getChattersPort: GetChattersPort,
) {
    fun getChatters(): List<Chatter> {
        return getChattersPort.getChatters().map { it.mapToDomain() }
    }
}
