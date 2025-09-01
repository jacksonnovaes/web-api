package com.aurora.webapi.modules.fichas.adapters.outbound.repositories

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.RoloEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoloRepository: JpaRepository<RoloEntity, Long>{
    
    
    fun findAllByNomeAndStatus(pageable: Pageable, termo: String, active: StatusEnum): Page<RoloEntity>
    fun findAllByStatus(active: StatusEnum, pageable: Pageable): Page<RoloEntity>

}