package com.aurora.webapi.modules.fichas.application.usecases.anoColecao.impl

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.AnoColecaoEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.AnoColecaoRepository
import com.aurora.webapi.modules.fichas.application.usecases.anoColecao.ListAnoColecao
import org.springframework.stereotype.Service

@Service
class ListAnoColecaoImpl(
    val anoColecaoRepository: AnoColecaoRepository
): ListAnoColecao {

     override fun execute(): List<AnoColecaoEntity> {
        return anoColecaoRepository.findAll()
    }
}