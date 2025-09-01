package com.aurora.webapi.modules.fichas.adapters.outbound.repositories

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CorEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CorRepository: JpaRepository<CorEntity, Long>{

    fun findByNome(nome: String): CorEntity

    fun findByValorHexadecimal(valorHex: String): CorEntity
    @Query("SELECT c FROM CorEntity c  WHERE lower(c.nome) LIKE lower(concat('%', :nome, '%'))")
    fun findByNome(nome: String, pageable: Pageable): Page<CorEntity>
}