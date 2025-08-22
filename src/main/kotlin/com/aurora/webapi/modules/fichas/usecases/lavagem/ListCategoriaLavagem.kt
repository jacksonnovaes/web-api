package com.aurora.webapi.modules.fichas.usecases.lavagem

import com.aurora.webapi.modules.fichas.infra.entity.CategoriaLavagemEntity
import com.aurora.webapi.modules.fichas.service.lavagem.CategoriaLagameService
import org.springframework.stereotype.Service

@Service
class ListCategoriaLavagem(
    val categoriaLagameService: CategoriaLagameService
) {

    fun execute(): List<CategoriaLavagemEntity>{
        return categoriaLagameService.buscarTodos()
    }
}
