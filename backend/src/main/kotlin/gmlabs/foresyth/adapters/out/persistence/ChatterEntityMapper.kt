package gmlabs.foresyth.adapters.out.persistence

import gmlabs.foresyth.domain.Chatter
import gmlabs.foresyth.domain.ChatterId

fun ChatterEntity.mapToDomain(): Chatter {
    return Chatter(chatterId = ChatterId(id), firstName = firstName, password = password)
}

fun Chatter.mapToEntity(): ChatterEntity {
    return ChatterEntity(id = chatterId.value, firstName = firstName, password = password)
}
