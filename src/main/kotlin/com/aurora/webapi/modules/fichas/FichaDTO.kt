package com.aurora.webapi.modules.fichas

import java.time.LocalDate

data class FichaDTO(
    val id: Long? = null,
    val numeroFicha: Int,
    val notaFiscal: Int,
    val dataEntrada: LocalDate?,
    val largura: Float,
    val colecaoId: Long?,
    val composicaoId: Long?,
    val fornecedorId: Long?
) {

}
