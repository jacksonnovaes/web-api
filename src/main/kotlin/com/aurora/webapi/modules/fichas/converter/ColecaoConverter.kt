package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.infra.entity.ColecaoEntity
import com.aurora.webapi.modules.fichas.ColecaoDTO

object ColecaoConverter {
    fun toEntity(colecao: ColecaoDTO): ColecaoEntity {
        return ColecaoEntity(
            id = colecao.id,
            nome = colecao.nome,
            ano = colecao.ano,
        )
    }

    fun toDTO(colecao: ColecaoEntity): ColecaoDTO {
        return ColecaoDTO(
            id = colecao.id!!,
            nome = colecao.nome,
            ano = colecao.ano,
        )
    }

}


