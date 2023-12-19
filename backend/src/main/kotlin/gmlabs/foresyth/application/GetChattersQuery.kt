package gmlabs.foresyth.application

import gmlabs.foresyth.application.ports.out.GetChattersPort
import org.springframework.stereotype.Service

@Service
class GetChattersQuery(
    val getChattersPort: GetChattersPort,
) {
    fun getChatters(): List<Chatter> {
        return getChattersPort.getChatters().map {
            Chatter(it.firstName)
        }
    }
}
