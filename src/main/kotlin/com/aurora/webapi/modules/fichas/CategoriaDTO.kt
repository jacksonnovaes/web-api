package com.aurora.webapi.modules.fichas

data class CategoriaDTO(
    val id: Long? = null,
    val nome: String
){
    companion object {
        fun onlyId(id: Long?) = CategoriaDTO(id, "")
    }
}
