package com.aurora.webapi.modules.fichas

data class ArtigoDTO(
    val id: Long? = null,
    val nome: String,
    val instrucoes: List<Long>? = emptyList()
) {
    companion object {
        fun onlyId(id: Long?) = ArtigoDTO(id, "", emptyList())
    }
}
