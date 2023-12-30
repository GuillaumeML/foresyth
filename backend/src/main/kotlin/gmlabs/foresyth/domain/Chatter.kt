package gmlabs.foresyth.domain

import java.util.*

data class Chatter(val chatterId: ChatterId, val firstName: String?)

class ChatterId(
    val value: UUID,
)
