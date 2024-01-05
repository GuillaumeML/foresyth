package gmlabs.foresyth.application.ports.out

import gmlabs.foresyth.adapters.out.persistence.chatter.ChatterEntity

interface GetChattersPort {
    fun getChatters(): List<ChatterEntity>
}
