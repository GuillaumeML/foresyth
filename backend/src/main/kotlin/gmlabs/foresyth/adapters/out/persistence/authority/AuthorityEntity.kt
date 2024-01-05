package gmlabs.foresyth.adapters.out.persistence.authority

import gmlabs.foresyth.adapters.out.persistence.chatter.ChatterEntity
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "authorities")
@IdClass(AuthorityId::class)
class AuthorityEntity(
    @Id
    @Column(name = "username")
    var username: String,

    @Id
    @Column(name = "authority", nullable = false, length = 50)
    var authority: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false, insertable = false, updatable = false)
    var chatter: ChatterEntity
)

class AuthorityId(
    var username: String? = null, // Corresponds to the username field in AuthorityEntity
    var authority: String? = null
) : Serializable