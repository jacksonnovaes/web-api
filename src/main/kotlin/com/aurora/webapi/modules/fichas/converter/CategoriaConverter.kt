package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.CategoriaDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CategoriaEntity


object CategoriaConverter {

    fun toEntity(entity: CategoriaDTO): CategoriaEntity {
        return CategoriaEntity(
            id = entity.id,
            nome = entity.nome,
        )
    }

    fun toDTO(entity: CategoriaEntity): CategoriaDTO {
        return CategoriaDTO(
            id = entity.id,
            nome = entity.nome,
        )
    }
}