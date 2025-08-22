package com.aurora.webapi.modules.fichas.infra.repositories

import com.aurora.webapi.modules.fichas.infra.entity.AnoColecaoEntity
import com.aurora.webapi.modules.fichas.infra.entity.ColecaoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnoColecaoRepository: JpaRepository<AnoColecaoEntity, Long>{

    fun findByAno(ano: String): AnoColecaoEntity
}