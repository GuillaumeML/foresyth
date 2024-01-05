package gmlabs.foresyth.application

import gmlabs.foresyth.adapters.out.persistence.chatter.ChatterEntity
import gmlabs.foresyth.adapters.out.persistence.chatter.ChatterRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class ChatterDetailsService(val chatterRepository: ChatterRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val chatterEntity: ChatterEntity = chatterRepository.findByUsername(username)
        return ChatterPrincipal(chatterEntity)
    }
}

class ChatterPrincipal(private val chatterEntity: ChatterEntity) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return chatterEntity.authorities.map { SimpleGrantedAuthority(it.authority) }
    }

    override fun getPassword(): String {
        return chatterEntity.password
    }

    override fun getUsername(): String {
        return chatterEntity.username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
