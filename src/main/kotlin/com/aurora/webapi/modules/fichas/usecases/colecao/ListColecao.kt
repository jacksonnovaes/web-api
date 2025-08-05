package com.aurora.webapi.modules.fichas.usecases.colecao

import com.aurora.webapi.modules.fichas.infra.entity.ColecaoEntity
import com.aurora.webapi.modules.fichas.service.colecao.ColecaoService
import org.springframework.stereotype.Service

@Service
class ListColecao(
    val colecaoService: ColecaoService
) {

    fun execute(): List<ColecaoEntity> {
        return colecaoService.buscarTodos()
    }
}