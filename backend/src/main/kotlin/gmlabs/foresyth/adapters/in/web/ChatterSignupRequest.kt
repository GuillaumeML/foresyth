package gmlabs.foresyth.adapters.`in`.web

import gmlabs.foresyth.domain.Chatter

data class ChatterSignupRequest(val chatterName: String, var password: String)

fun ChatterSignupRequest.mapToDomain(): Chatter {
    return Chatter(chatterName, password, enabled = true)
}
