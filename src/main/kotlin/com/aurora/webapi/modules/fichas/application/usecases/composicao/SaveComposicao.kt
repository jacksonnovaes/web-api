package com.aurora.webapi.modules.fichas.application.usecases.composicao

import com.aurora.webapi.modules.fichas.ComposicaoDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.ComposicaoRepository
import com.aurora.webapi.modules.fichas.converter.ComposicaoConverter
import org.springframework.stereotype.Service

@Service
class SaveComposicao(
    val composicaoRepository: ComposicaoRepository
) {

    fun execute(composicaoDTO: ComposicaoDTO): ComposicaoDTO {
        val composicaoEntity = ComposicaoConverter.toEntity(composicaoDTO)
        val composicao = ComposicaoConverter.toDTO(composicaoRepository.save(composicaoEntity))
        return composicao
    }
}