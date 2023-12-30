package gmlabs.foresyth.adapters.out.persistence

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "chatter_entity")
class ChatterEntity(
    @Id var id: UUID,
    var firstName: String,
) {
    // No-argument constructor for JPA
    constructor() : this(UUID.randomUUID(), "")
}
