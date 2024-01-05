package gmlabs.foresyth.adapters.out.persistence.authority

import gmlabs.foresyth.application.ports.out.SaveAuthorityPort
import gmlabs.foresyth.domain.Authority
import org.springframework.stereotype.Component

@Component
class AuthorityPersistenceAdapter(
    private val authorityRepository: AuthorityRepository
): SaveAuthorityPort {
    override fun saveAuthority(authority: Authority) {
       authorityRepository.save(authority.mapToEntity())
    }
}