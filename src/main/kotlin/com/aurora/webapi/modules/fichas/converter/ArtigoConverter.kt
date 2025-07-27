package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.ArtigoResponseDTO
import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.LavagenRespondeDTO
import com.aurora.webapi.modules.fichas.infra.entity.ArtigoEntity
import com.aurora.webapi.modules.fichas.infra.entity.LavagenEntity

object ArtigoConverter {

    fun toEntity(entity: ArtigoDTO): ArtigoEntity {
        return ArtigoEntity(
            id = null,
            nome = entity.nome,
            instrucions = entity.instrucoes?.map { LavagenEntity(id = it, descricao = "", code = 0, imagem = ByteArray(0)) } ?: emptyList()
        )
    }

    fun toDTO(entity: ArtigoEntity): ArtigoResponseDTO {
        return ArtigoResponseDTO(
            id = null,
            nome = entity.nome,
            instrucoes = entity.instrucions?.map { it
                LavagenRespondeDTO(
                    it.id,
                    it.descricao,
                    it.code,
                    it.imagem
                )
            }

        )
    }


}