package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.AnoColecaoDTO
import com.aurora.webapi.modules.fichas.infra.entity.ColecaoEntity
import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.ColecaoResponseDTO
import com.aurora.webapi.modules.fichas.enums.StatusEnum
import com.aurora.webapi.modules.fichas.infra.entity.AnoColecaoEntity

object ColecaoConverter {
    fun toEntity(colecao: ColecaoDTO): ColecaoEntity {
        return ColecaoEntity(
            id = colecao.id,
            descricao = colecao.nome,
            anoCoelecao = AnoColecaoConverter.toEntity(AnoColecaoDTO.onlyId(colecao.anoColecaoId)),
            fichas = emptyList(),
            status = StatusEnum.fromValue(colecao.status)
        )
    }

    fun toDTO(colecao: ColecaoEntity): ColecaoResponseDTO {
        return ColecaoResponseDTO(
            id = colecao.id!!,
            nome = colecao.descricao,
            ano = colecao.anoCoelecao?.ano,
            anoColecaoId = colecao.anoCoelecao?.id
        )
    }

}


