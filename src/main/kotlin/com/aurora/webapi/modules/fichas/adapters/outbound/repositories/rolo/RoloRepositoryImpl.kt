package com.aurora.webapi.modules.fichas.adapters.outbound.repositories.rolo

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.RoloEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

class RoloRepositoryImpl(
    private val roloRepository: JpaRoloRepository
) : RoloRepository{

    override fun save(rolo: RoloEntity) {
        roloRepository.save(rolo)
    }

    override fun findAllByCodigoAndStatus(
        pageable: Pageable,
        termo: String,
        active: StatusEnum
    ): Page<RoloEntity> {
        TODO("Not yet implemented")
    }

    override fun findAllByStatus(
        active: StatusEnum,
        pageable: Pageable
    ): Page<RoloEntity> {
        TODO("Not yet implemented")
    }
}