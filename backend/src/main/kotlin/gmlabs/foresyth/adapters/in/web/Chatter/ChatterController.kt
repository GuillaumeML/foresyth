package gmlabs.foresyth.adapters.`in`.web.Chatter

import gmlabs.foresyth.application.GetChattersQuery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatterController(
    private val getChattersQuery: GetChattersQuery,
) {
    @GetMapping("/chatters")
    fun getChatters(): List<ChatterResponse> {
        return getChattersQuery.getChatters().map { ChatterResponse(username = it.username) }
    }
}
