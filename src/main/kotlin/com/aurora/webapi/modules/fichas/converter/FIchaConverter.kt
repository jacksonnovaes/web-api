package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.ComposicaoDTO
import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.infra.entity.FichaEntity
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object FichaConverter {

    fun toEntity(ficha: FichaDTO): FichaEntity {

        return FichaEntity(
            id = null,
            numeroFicha = ficha.numeroFicha.toString(),
            notaFiscal = ficha.notaFiscal.toString(),
            dataEntrada = ficha?.dataEntrada,
            dataRegistro = LocalDateTime.now(),
            colecao = ColecaoConverter.toEntity(ColecaoDTO.onlyId(ficha.colecaoId)),
            composicao = ComposicaoConverter.toEntity(ComposicaoDTO.onlyId(ficha.composicaoId)),
            fornecedor = FornecedorConverter.toEntity(FornecedorDTO.onlyId(ficha.fornecedorId)),
            largura = ficha.largura
        )
    }

    fun toDTO(entity: FichaEntity): FichaDTO {
        return FichaDTO(
            id = entity.id,

            numeroFicha = entity.numeroFicha.toInt(),
            notaFiscal = entity.notaFiscal.toInt(),
            dataEntrada = entity.dataEntrada,
            colecaoId = ColecaoConverter.toDTO(entity.colecao).id,
            composicaoId = ComposicaoConverter.toDTO(entity.composicao).id,
            fornecedorId = FornecedorConverter.toDTO(entity.fornecedor).id,
            largura = entity.largura,
        )
    }


}