package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.ArtigoResponseDTO
import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.ComposicaoDTO
import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.FichaReponseDTO
import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.infra.entity.FichaEntity
import java.time.LocalDateTime

object FichaConverter {

    fun toEntity(ficha: FichaDTO): FichaEntity {

        return FichaEntity(
            id = ficha.id,
            numeroFicha = ficha.numeroFicha.toString(),
            notaFiscal = ficha.notaFiscal.toString(),
            dataEntrada = ficha.dataEntrada,
            dataRegistro = LocalDateTime.now(),
            anoColecao = ficha.anoColecao,
            colecao = ColecaoConverter.toEntity(ColecaoDTO.onlyId(ficha.colecaoId)),
            composicao = ComposicaoConverter.toEntity(ComposicaoDTO.onlyId(ficha.composicaoId)),
            fornecedor = FornecedorConverter.toEntity(FornecedorDTO.onlyId(ficha.fornecedorId)),
            largura = ficha.largura,
            artigo = ArtigoConverter.toEntity(ArtigoDTO.onlyId(ficha.artigoId))
        )
    }

    fun toDTO(entity: FichaEntity): FichaDTO {
        return FichaDTO(
            id = entity.id,
            numeroFicha = entity.numeroFicha.toInt(),
            notaFiscal = entity.notaFiscal.toInt(),
            dataEntrada = entity.dataEntrada,
            anoColecao = entity.anoColecao,
            colecaoId = ColecaoConverter.toDTO(entity.colecao).id,
            artigoId = ArtigoConverter.toDTO(entity.artigo).id,
            composicaoId = ComposicaoConverter.toDTO(entity.composicao).id,
            fornecedorId = FornecedorConverter.toDTO(entity.fornecedor).id,
            largura = entity.largura,
        )
    }

    fun toResponseDTO(entity: FichaEntity): FichaReponseDTO {
        return FichaReponseDTO(
            id = entity.id,
            numeroFicha = entity.numeroFicha.toInt(),
            notaFiscal = entity.notaFiscal.toInt(),
            dataEntrada = entity.dataEntrada,
            artigo = entity.artigo.nome,
            colecao = entity.colecao.nome,
            anoColecao = entity.colecao.ano,
            composicao = entity.composicao.descricao,
            fornecedor = entity.fornecedor.nome,
            largura = entity.largura,
        )
    }


}