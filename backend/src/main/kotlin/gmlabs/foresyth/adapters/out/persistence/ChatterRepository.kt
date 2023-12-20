package gmlabs.foresyth.adapters.out.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ChatterRepository : JpaRepository<ChatterEntity, UUID> {
    override fun findAll(): List<ChatterEntity>
}
