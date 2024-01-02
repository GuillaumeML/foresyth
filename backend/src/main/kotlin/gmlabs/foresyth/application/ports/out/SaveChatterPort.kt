package gmlabs.foresyth.application.ports.out

import gmlabs.foresyth.domain.Chatter

interface SaveChatterPort {
    fun saveChatter(chatter: Chatter)
}
