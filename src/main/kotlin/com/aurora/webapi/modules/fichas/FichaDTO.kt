package com.aurora.webapi.modules.fichas

import java.time.LocalDate

data class FichaDTO(
    val id: Long? = null,
    val numeroFicha: Int,
    val notaFiscal: Int,
    val dataEntrada: LocalDate?,
    val anoColecao: Int,
    val largura: Float,
    val artigoId: Long?,
    val colecaoId: Long?,
    val composicaoId: Long?,
    val fornecedorId: Long?
)

data class FichaReponseDTO(
    val id: Long? = null,
    val numeroFicha: Int,
    val notaFiscal: Int,
    val dataEntrada: LocalDate?,
    val largura: Float,
    val artigo: String,
    val colecao: String,
    val anoColecao: Int,
    val composicao: String,
    val fornecedor: String
)


