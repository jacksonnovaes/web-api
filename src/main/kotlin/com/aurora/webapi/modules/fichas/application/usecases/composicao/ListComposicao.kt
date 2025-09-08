package com.aurora.webapi.modules.fichas.application.usecases.composicao

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ComposicaoEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.ComposicaoRepository
import org.springframework.stereotype.Service

@Service
class ListComposicao(
    val composicaoRepository: ComposicaoRepository
) {

    fun execute(): List<ComposicaoEntity> {
        return composicaoRepository.findAll()
    }
}