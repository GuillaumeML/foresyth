package gmlabs.foresyth.adapters.out.persistence.authority

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorityRepository : CrudRepository<AuthorityEntity, Long> {
    fun save(authorityEntity: AuthorityEntity)
}
