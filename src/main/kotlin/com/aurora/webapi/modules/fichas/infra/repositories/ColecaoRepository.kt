package com.aurora.webapi.modules.fichas.infra.repositories

import com.aurora.webapi.modules.fichas.enums.StatusEnum
import com.aurora.webapi.modules.fichas.infra.entity.ColecaoEntity
import com.aurora.webapi.modules.fichas.infra.entity.FornecedorEntity
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
    fun findAll(@Param("status")statusEnum: StatusEnum,pageable: Pageable): Page<ColecaoEntity>
}