package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.AnoColecaoDTO
import com.aurora.webapi.modules.fichas.AnoColecaoResponseDTO
import com.aurora.webapi.modules.fichas.infra.entity.AnoColecaoEntity

object AnoColecaoConverter {
    fun toEntity(anoColecao: AnoColecaoDTO): AnoColecaoEntity {
        return AnoColecaoEntity(
            id = anoColecao.id,
            ano = anoColecao.nome,
        )
    }

    fun toDTO(entity: AnoColecaoEntity?): AnoColecaoResponseDTO{
        return AnoColecaoResponseDTO(
            id = entity?.id,
            ano = entity?.ano ?: "",
        )
    }

}


