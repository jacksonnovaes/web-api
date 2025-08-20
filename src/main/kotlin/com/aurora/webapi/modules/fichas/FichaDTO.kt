package com.aurora.webapi.modules.fichas

import com.aurora.webapi.modules.fichas.enums.StatusEnum
import java.time.LocalDate

data class FichaDTO(
    val id: Long? = null,
    val numeroFicha: Int,
    val notaFiscal: Int,
    val dataEntrada: LocalDate?,
    val largura: Float,
    val artigoId: Long?,
    val artigo: String?,
    val colecaoId: Long?,
    val anoColecaoId: Long?,
    val composicaoId: Long?,
    val fornecedorId: Long?,
    val status: String = StatusEnum.ACTIVE.value
)

data class FichaReponseDTO(
    val id: Long? = null,
    val numeroFicha: Int,
    val notaFiscal: Int,
    val dataEntrada: LocalDate?,
    val largura: Float,
    val artigoId: Long?,
    val artigo: String,
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


