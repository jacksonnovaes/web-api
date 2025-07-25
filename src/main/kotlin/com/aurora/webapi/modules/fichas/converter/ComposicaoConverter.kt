package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.ComposicaoDTO
import com.aurora.webapi.modules.fichas.infra.entity.ComposicaoEntity

object ComposicaoConverter {
    fun toEntity(composicao: ComposicaoDTO): ComposicaoEntity {
        return ComposicaoEntity(
            id = composicao.id,
            descricao = composicao.descricao,
            cor = composicao.cor,
            fichas = emptyList()
        )
    }



    fun toDTO(composicao: ComposicaoEntity): ComposicaoDTO {
        return ComposicaoDTO(
            id = composicao.id,
            descricao = composicao.descricao,
            cor = composicao.cor
        )
    }

}