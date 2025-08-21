package com.aurora.webapi.modules.fichas.converter

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.ComposicaoDTO
import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.FichaReponseDTO
import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.enums.StatusEnum
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
            status = StatusEnum.fromValue(ficha.status)!!,
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
            colecaoId = ColecaoConverter.toDTO(entity.colecao).id,
            artigoId = ArtigoConverter.toDTO(entity.artigo).id,
            artigo = ArtigoConverter.toDTO(entity.artigo).nome,
            status = entity.status.value,
            anoColecaoId = AnoColecaoConverter.toDTO(entity.colecao.anoCoelecao).id,
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
            artigoId = entity.artigo.id,
            artigo = entity.artigo.nome,
            status = entity.status,
            colecaoId = entity.colecao.id,
            colecao = entity.colecao.descricao,
            anoColecaoId = entity.colecao.anoCoelecao?.id,
            anoColecao = entity.colecao.anoCoelecao?.ano ?: "",
            composicaoId = entity.composicao.id,
            composicao = entity.composicao.descricao,
            fornecedorId = entity.fornecedor.id,
            fornecedor = entity.fornecedor.nome,
            largura = entity.largura,
        )
    }


}