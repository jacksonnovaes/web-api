package com.aurora.webapi.modules.fichas

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.FichaEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import java.time.LocalDate
import java.time.LocalDateTime

data class FichaDTO(
    val id: Long? = null,
    val numeroFicha: Int,
    val notaFiscal: Int,
    val dataEntrada: LocalDate?,
    val largura: Float,
    val artigoId: Long?,
    val colecaoId: Long?,
    val composicaoId: Long?,
    val fornecedorId: Long?,
    val status: String = StatusEnum.ACTIVE.value
)

data class FichaReponseDTO(
    val id: Long? = null,
    val numeroFicha: String,
    val notaFiscal: String,
    val dataEntrada: LocalDate?,
    val largura: Float,
    val artigoId: Long?,
    val artigo: String?,
    val status: StatusEnum?,
    val colecao: String,
    val anoColecao: String,
    val composicao: String,
    val fornecedor: String,
    val colecaoId: Long?,
    val anoColecaoId: Long?,
    val composicaoId: Long?,
    val fornecedorId: Long?
)

fun FichaDTO.toEntity() = FichaEntity(
    id = this.id,
    numeroFicha = this.numeroFicha.toString(),
    notaFiscal = this.notaFiscal.toString(),
    dataEntrada = this.dataEntrada,
    dataRegistro = LocalDateTime.now(),
    largura = this.largura,
    status = StatusEnum.fromValue(this.status)!!,
    colecao = this.colecaoId,
    artigo = this.artigoId,
    composicao = this.composicaoId,
    fornecedor = this.fornecedorId,
)
