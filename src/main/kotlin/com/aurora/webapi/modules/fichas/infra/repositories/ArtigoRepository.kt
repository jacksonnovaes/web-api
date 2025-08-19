package com.aurora.webapi.modules.fichas.infra.repositories

import com.aurora.webapi.modules.fichas.enums.StatusEnum
import com.aurora.webapi.modules.fichas.infra.entity.ArtigoEntity
import jakarta.transaction.Status
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ArtigoRepository: JpaRepository<ArtigoEntity, Long>{

    fun findAllByStatus(status: StatusEnum, pageable: Pageable): Page<ArtigoEntity>

    fun findAllByNomeAndStatus(pageable: Pageable, @Param("nome") nome: String,@Param("status") status: String): Page<ArtigoEntity>
}