package gmlabs.foresyth.adapters.out.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ChatterRepository : JpaRepository<ChatterEntity, UUID> {
    // You can define custom query methods here if needed

    override fun findAll(): List<ChatterEntity>
}
