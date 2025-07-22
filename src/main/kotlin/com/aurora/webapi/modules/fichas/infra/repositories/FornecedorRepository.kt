package com.aurora.webapi.modules.fichas.infra.repositories

import com.aurora.webapi.modules.fichas.infra.entity.FornecedorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FornecedorRepository: JpaRepository<FornecedorEntity, Long>{

    override fun findAll(): List<FornecedorEntity>

    fun findByNome(name: String)
}