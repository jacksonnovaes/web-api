package com.aurora.webapi.modules.fichas

import java.time.LocalDate

data class FichaDTO(
    val id: Long? = null,
    val numeroFicha: String,
    val notaFiscal: String,
    val dataEntrada: LocalDate,
    val colecaoId: Long?,
    val composicaoId: Long?
) {

}
