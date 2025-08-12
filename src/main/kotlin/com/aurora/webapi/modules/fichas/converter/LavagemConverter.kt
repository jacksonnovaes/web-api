package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.LavagenRespondeDTO
import com.aurora.webapi.modules.fichas.infra.entity.CategoriaLavagemEntity
import com.aurora.webapi.modules.fichas.infra.entity.FornecedorEntity
import com.aurora.webapi.modules.fichas.infra.entity.LavagenEntity

object LavagemConverter {

    fun toEntity(lavagemDTO: LavagenDTO): LavagenEntity {
        return LavagenEntity(
            id = lavagemDTO.id,
            descricao = lavagemDTO.descricao,
            code = lavagemDTO.code,
            imagem = lavagemDTO.imagem,
            categoria = CategoriaLavagemEntity(
                lavagemDTO.lavagemCategoriaID,
                descricao = ""
            )

        )
    }

    fun toDTO(entity: FornecedorEntity): FornecedorDTO {
        return FornecedorDTO(
            id = entity.id,
            nome = entity.nome,
            fichas = entity.fichas
        )
    }


}