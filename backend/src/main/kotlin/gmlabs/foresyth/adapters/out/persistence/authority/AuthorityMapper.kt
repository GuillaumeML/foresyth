package gmlabs.foresyth.adapters.out.persistence.authority

import gmlabs.foresyth.adapters.out.persistence.chatter.mapToDomain
import gmlabs.foresyth.adapters.out.persistence.chatter.mapToEntity
import gmlabs.foresyth.domain.Authority

fun AuthorityEntity.mapToDomain(): Authority {
    return Authority(chatter = chatter.mapToDomain(), authority = authority)
}

fun Authority.mapToEntity(): AuthorityEntity {
    return AuthorityEntity(chatter = chatter.mapToEntity(), authority = authority, username = chatter.username)
}
