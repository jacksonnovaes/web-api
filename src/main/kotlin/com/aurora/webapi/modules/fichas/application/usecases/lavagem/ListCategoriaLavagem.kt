package com.aurora.webapi.modules.fichas.application.usecases.lavagem

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CategoriaLavagemEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.CategoriaLagamRepository
import org.springframework.stereotype.Service

@Service
class ListCategoriaLavagem(
    val categoriaLagamRepository: CategoriaLagamRepository
) {

    fun execute(): List<CategoriaLavagemEntity>{
        return categoriaLagamRepository.findAll()
    }
}
