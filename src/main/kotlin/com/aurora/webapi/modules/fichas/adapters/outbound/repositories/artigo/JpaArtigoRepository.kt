package com.aurora.webapi.modules.fichas.adapters.outbound.repositories.artigo

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ArtigoEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface JpaArtigoRepository: JpaRepository<ArtigoEntity, Long> {

    fun findAllByStatus(status: StatusEnum, pageable: Pageable): Page<ArtigoEntity>
    @Query("""
    SELECT a 
    FROM ArtigoEntity a 
    WHERE lower(a.nome) LIKE lower(concat('%', :nome, '%'))
      AND a.status = :status
""")
    fun findAllByNomeAndStatus(pageable: Pageable, @Param("nome") nome: String, @Param("status") status: StatusEnum): Page<ArtigoEntity>
}