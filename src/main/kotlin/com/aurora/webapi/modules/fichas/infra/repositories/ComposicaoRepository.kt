package com.aurora.webapi.modules.fichas.infra.repositories

import com.aurora.webapi.modules.fichas.infra.entity.ComposicaoEntity
import com.aurora.webapi.modules.fichas.infra.entity.FichaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComposicaoRepository: JpaRepository<ComposicaoEntity, Long>{
}