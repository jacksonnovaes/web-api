package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.ArtigoResponseDTO
import com.aurora.webapi.modules.fichas.CategoriaDTO
import com.aurora.webapi.modules.fichas.LavagenRespondeDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ArtigoEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.LavagemEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum

object ArtigoConverter {

    fun toEntity(entity: ArtigoDTO): ArtigoEntity {
        return ArtigoEntity(
            id = entity.id,
            nome = entity.nome,
            instrucions = entity.instrucoes.map {
                LavagemEntity(
                    id = it,
                    descricao = "",
                    code = 0,
                    imagem = ByteArray(0),
                    categoria = null
                )
            },
            categotia = CategoriaConverter.toEntity(CategoriaDTO.onlyId(entity.categoriaId)),
            status = StatusEnum.fromValue(entity.status)
        )
    }

    fun toDTO(entity: ArtigoEntity): ArtigoResponseDTO {
        return ArtigoResponseDTO(
            id = entity.id,
            nome = entity.nome,
            categoriaDTO = CategoriaDTO(
                id = entity.categotia.id,
                nome = entity.categotia.nome
            ),
            instrucoes = entity.instrucions?.map {
                it
                LavagenRespondeDTO(
                    it.id,
                    it.descricao,

                    it.code,
                    it.imagem
                )
            },
            status = entity.status?.value
        )
    }

}