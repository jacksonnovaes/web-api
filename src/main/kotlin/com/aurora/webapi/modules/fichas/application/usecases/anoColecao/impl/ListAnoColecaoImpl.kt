package com.aurora.webapi.modules.fichas.application.usecases.anoColecao.impl

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.AnoColecaoEntity
import com.aurora.webapi.modules.fichas.application.usecases.anoColecao.ListAnoColecao
import com.aurora.webapi.modules.fichas.service.colecao.AnoColecaoService
import org.springframework.stereotype.Service

@Service
class ListAnoColecaoImpl(
    val anoColecaoService: AnoColecaoService
): ListAnoColecao {

     override fun execute(): List<AnoColecaoEntity> {
        return anoColecaoService.buscarTodos()
    }
}