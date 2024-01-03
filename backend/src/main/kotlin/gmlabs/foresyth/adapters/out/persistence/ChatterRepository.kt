package gmlabs.foresyth.adapters.out.persistence

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ChatterRepository : CrudRepository<ChatterEntity, UUID> {
    @Query(
        """
        select u from ChatterEntity u
    """,
    )
    override fun findAll(): List<ChatterEntity>

    fun findByUsername(username: String): ChatterEntity

    fun save(chatterEntity: ChatterEntity)
}
