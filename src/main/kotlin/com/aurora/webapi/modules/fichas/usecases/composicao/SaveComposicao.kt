package com.aurora.webapi.modules.fichas.usecases.composicao

import com.aurora.webapi.modules.fichas.ComposicaoDTO
import com.aurora.webapi.modules.fichas.converter.ComposicaoConverter
import com.aurora.webapi.modules.fichas.service.composicao.composicaoService
import org.springframework.stereotype.Service

@Service
class SaveComposicao(
    val composicaoService: composicaoService
) {

    fun execute(composicaoDTO: ComposicaoDTO): ComposicaoDTO {
        val composicaoEntity = ComposicaoConverter.toEntity(composicaoDTO)
        val composicao = ComposicaoConverter.toDTO(composicaoService.save(composicaoEntity))
        return composicao
    }
}