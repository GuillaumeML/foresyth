package gmlabs.foresyth.adapters.out.persistence.chatter

import gmlabs.foresyth.adapters.out.persistence.authority.AuthorityEntity
import jakarta.persistence.*

@Entity
@Table(name = "chatters_entity", schema = "public")
class ChatterEntity(
    @Id
    @Column(name = "username", nullable = false, length = 50)
    var username: String,

    @Column(name = "password", nullable = false, length = 500)
    var password: String,

    @Column(name = "enabled", nullable = false)
    var enabled: Boolean,

    @OneToMany(mappedBy = "chatter", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var authorities: Set<AuthorityEntity> = HashSet()
)
