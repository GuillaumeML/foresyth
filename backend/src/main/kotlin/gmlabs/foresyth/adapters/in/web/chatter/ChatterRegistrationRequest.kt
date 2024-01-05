package gmlabs.foresyth.adapters.`in`.web.chatter

import gmlabs.foresyth.domain.Chatter

data class ChatterRegistrationRequest(val chatterName: String, var password: String)

fun ChatterRegistrationRequest.mapToDomain(): Chatter {
    return Chatter(chatterName, password, enabled = true)
}
