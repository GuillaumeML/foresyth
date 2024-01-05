package gmlabs.foresyth.application.ports.out

import gmlabs.foresyth.domain.Authority

interface SaveAuthorityPort {
    fun saveAuthority(authority: Authority)
}