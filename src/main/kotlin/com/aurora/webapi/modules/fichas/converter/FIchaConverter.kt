package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.ComposicaoDTO
import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.infra.entity.FichaEntity

object FichaConverter {

    fun toEntity(ficha: FichaDTO): FichaEntity {
        return FichaEntity(
            id = null,
            numeroFicha = ficha.numeroFicha,
            notaFiscal = ficha.notaFiscal,
            dataEntrada = ficha.dataEntrada,
            colecao = ColecaoConverter.toEntity(ColecaoDTO.onlyId(ficha.colecaoId)),
            composicao = ComposicaoConverter.toEntity(ComposicaoDTO.onlyId(ficha.composicaoId)),
            fornecedor = FornecedorConverter.toEntity(FornecedorDTO.onlyId(ficha.fornecedorId)),
            largura = ficha.largura
        )
    }

    fun toDTO(entity: FichaEntity): FichaDTO {
        return FichaDTO(
            id = entity.id,

            numeroFicha = entity.numeroFicha,
            notaFiscal = entity.notaFiscal,
            dataEntrada = entity.dataEntrada,
            colecaoId = ColecaoConverter.toDomain(entity.colecao).id,
            composicaoId = ComposicaoConverter.toDTO(entity.composicao).id,
            fornecedorId = FornecedorConverter.toDTO(entity.fornecedor).id,
            largura = entity.largura,
        )
    }


}