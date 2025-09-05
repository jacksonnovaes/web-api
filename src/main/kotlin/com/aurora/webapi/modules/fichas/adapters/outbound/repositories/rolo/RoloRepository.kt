package com.aurora.webapi.modules.fichas.adapters.outbound.repositories.rolo

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.RoloEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface RoloRepository {
    fun save(rolo: RoloEntity)
    fun findAllByCodigoAndStatus(pageable: Pageable, termo: String, active: StatusEnum): Page<RoloEntity>
    fun findAllByStatus(active: StatusEnum, pageable: Pageable): Page<RoloEntity>

}