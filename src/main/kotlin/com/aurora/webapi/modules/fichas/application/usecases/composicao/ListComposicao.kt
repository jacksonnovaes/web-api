package com.aurora.webapi.modules.fichas.application.usecases.composicao

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ComposicaoEntity
import com.aurora.webapi.modules.fichas.service.composicao.composicaoService
import org.springframework.stereotype.Service

@Service
class ListComposicao(
    val composicaoService: composicaoService
) {

    fun execute(): List<ComposicaoEntity> {
        return composicaoService.buscarTodos()
    }
}