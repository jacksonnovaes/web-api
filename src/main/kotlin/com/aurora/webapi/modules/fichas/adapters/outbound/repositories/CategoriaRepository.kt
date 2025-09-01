package com.aurora.webapi.modules.fichas.adapters.outbound.repositories

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CategoriaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository: JpaRepository<CategoriaEntity, Long>{
}