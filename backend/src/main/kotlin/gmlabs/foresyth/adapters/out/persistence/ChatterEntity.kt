package gmlabs.foresyth.adapters.out.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

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
)
