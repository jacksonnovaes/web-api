package com.aurora.webapi.modules.fichas.adapters.outbound.repositories.rolo

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.RoloEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.toDomain
import com.aurora.webapi.modules.fichas.domain.Rolo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class RoloRepositoryImpl(
    private val roloRepository: JpaRoloRepository
) : RoloRepository{

    override fun save(rolo: RoloEntity): Rolo {
      return  roloRepository.save(rolo).toDomain()
    }

    override fun findAllByCodigoAndStatus(
        pageable: Pageable,
        termo: String,
        active: StatusEnum
    ): Page<Rolo> {
        TODO("Not yet implemented")
    }

    override fun findAllByStatus(
        active: StatusEnum,
        pageable: Pageable
    ): Page<Rolo> {
        TODO("Not yet implemented")
    }
}