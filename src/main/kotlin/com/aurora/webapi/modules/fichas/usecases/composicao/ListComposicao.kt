package com.aurora.webapi.modules.fichas.usecases.composicao

import com.aurora.webapi.modules.fichas.infra.entity.ColecaoEntity
import com.aurora.webapi.modules.fichas.infra.entity.ComposicaoEntity
import com.aurora.webapi.modules.fichas.service.colecao.ColecaoService
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