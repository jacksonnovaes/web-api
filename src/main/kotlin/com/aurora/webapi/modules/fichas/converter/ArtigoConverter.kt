package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.infra.entity.ArtigoEntity

object ArtigoConverter {

    fun toEntity(entity: ArtigoDTO): ArtigoEntity {
        return ArtigoEntity(
            id = null,
            nome = entity.nome,
            instrucions = emptyList()
        )
    }

    fun toDTO(entity: ArtigoEntity): ArtigoDTO {
        return ArtigoDTO(
            id = null,
            nome = entity.nome,
            instrucoes = entity.instrucions?.map { it
                LavagenDTO(
                    it.id,
                    it.descricao,
                    it.code,
                    it.image
                )
            }

        )
    }


}