package gmlabs.foresyth.adapters.out.persistence

import gmlabs.foresyth.domain.Chatter

fun ChatterEntity.mapToDomain(): Chatter {
    return Chatter(username = username, password = password, enabled = enabled)
}

fun Chatter.mapToEntity(): ChatterEntity {
    return ChatterEntity(username = username, password = password, enabled = enabled)
}
