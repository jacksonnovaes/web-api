package com.aurora.webapi.modules.fichas.infra.repositories

import com.aurora.webapi.modules.fichas.infra.entity.ArtigoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArtigoRepository: JpaRepository<ArtigoEntity, Long>{
}