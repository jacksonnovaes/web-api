package com.aurora.webapi.modules.fichas.infra.repositories

import com.aurora.webapi.modules.fichas.infra.entity.LavagenEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LavagemRepository: JpaRepository<LavagenEntity, Long>{
}