package gmlabs.foresyth.application

import gmlabs.foresyth.application.ports.out.GetChattersPort
import gmlabs.foresyth.domain.Chatter
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class GetChattersQuery(
    val getChattersPort: GetChattersPort,
) {
    fun getChatters(): List<Chatter> {
        return getChattersPort.getChatters().map { Chatter(username = it.username, password = it.password, enabled = true) }
    }
}
