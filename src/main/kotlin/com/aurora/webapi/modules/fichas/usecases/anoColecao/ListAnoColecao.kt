package com.aurora.webapi.modules.fichas.usecases.anoColecao

import com.aurora.webapi.modules.fichas.infra.entity.AnoColecaoEntity
import com.aurora.webapi.modules.fichas.service.colecao.AnoColecaoService
import org.springframework.stereotype.Service

@Service
class ListAnoColecao(
    val anoColecaoService: AnoColecaoService
) {

    fun execute(): List<AnoColecaoEntity> {
        return anoColecaoService.buscarTodos()
    }
}