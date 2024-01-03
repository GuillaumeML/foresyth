package gmlabs.foresyth.adapters.out.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "chatters_entity", schema = "public")
class ChatterEntity(
    @Id
    @Column(name = "username", nullable = false)
    var username: String,
    @Column(name = "password", nullable = false)
    var password: String,
    @Column(name = "enabled", nullable = false)
    var enabled: Boolean,
)
