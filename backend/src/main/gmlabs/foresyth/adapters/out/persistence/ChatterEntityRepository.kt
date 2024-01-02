package gmlabs.foresyth.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ChatterEntityRepository : JpaRepository<ChatterEntity, UUID> {
}