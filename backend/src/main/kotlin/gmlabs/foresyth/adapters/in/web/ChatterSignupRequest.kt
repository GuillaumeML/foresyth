package gmlabs.foresyth.adapters.`in`.web

import gmlabs.foresyth.domain.Chatter
import gmlabs.foresyth.domain.ChatterId
import java.util.UUID

data class ChatterSignupRequest(val uuid: UUID = UUID.randomUUID(), val chatterName: String, var password: String)

fun ChatterSignupRequest.mapToDomain(): Chatter {
    return Chatter(ChatterId(uuid), chatterName, password)
}
