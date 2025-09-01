package com.aurora.webapi.modules.fichas.adapters.outbound.repositories

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ColecaoEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ColecaoRepository: JpaRepository<ColecaoEntity, Long>{
    @Query("""
    SELECT c 
    FROM ColecaoEntity c 
    WHERE c.status = :status
    """)
    fun findAll(@Param("status")statusEnum: StatusEnum, pageable: Pageable): Page<ColecaoEntity>
}