package gmlabs.foresyth.adapters.`in`.web

import gmlabs.foresyth.application.Chatter
import gmlabs.foresyth.application.GetChattersQuery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

// Runs locally on http://localhost:8080/
@RestController
class ChatterController(
    private val getChattersQuery: GetChattersQuery,
) {
    @GetMapping("/chatters")
    fun getUsers(): List<Chatter> {
        return getChattersQuery.getChatters()
    }
}
