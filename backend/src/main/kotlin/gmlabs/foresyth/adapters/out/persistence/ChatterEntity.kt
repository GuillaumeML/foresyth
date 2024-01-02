package gmlabs.foresyth.adapters.out.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "chatter_entity", schema = "public")
class ChatterEntity(
    @Id
    @Column(name = "id")
    var id: UUID,
    @Column(name = "name", nullable = false)
    var firstName: String,
    @Column(name = "password", nullable = false)
    var password: String,
)
