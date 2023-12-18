package gmlabs.foresyth.application.ports.out

import gmlabs.foresyth.adapters.out.persistence.ChatterEntity

interface GetChattersPort {
    fun getChatters(): List<ChatterEntity>
}