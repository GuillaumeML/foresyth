package gmlabs.foresyth.adapters.out.persistence

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class ChatterEntity {
    @Id
    var id: Int = 0
    var firstName: String? = null
}
