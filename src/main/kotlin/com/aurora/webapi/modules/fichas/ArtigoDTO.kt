package com.aurora.webapi.modules.fichas

data class ArtigoDTO(
    val id: Long? = null,
    val nome: String,
    val instrucoes: List<LavagenDTO>? = emptyList()
) {

}
