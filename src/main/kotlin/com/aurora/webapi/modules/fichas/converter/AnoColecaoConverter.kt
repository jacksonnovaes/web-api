package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.AnoColecaoResponseDTO
import com.aurora.webapi.modules.fichas.adapters.inbound.dto.AnoColecaoRequestDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.AnoColecaoEntity

object AnoColecaoConverter {
    fun toEntity(anoColecao: AnoColecaoRequestDTO): AnoColecaoEntity {
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


