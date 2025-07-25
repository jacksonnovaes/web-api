package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.infra.entity.FornecedorEntity

object FornecedorConverter {

    fun toEntity(fornecedor: FornecedorDTO): FornecedorEntity {
        return FornecedorEntity(
            id = fornecedor.id,
            nome = fornecedor.nome,
            fichas = emptyList()
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