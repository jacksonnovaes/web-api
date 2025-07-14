package com.aurora.webapi.modules.fichas

data class ColecaoDTO(
    val id: Long?=null,
    val nome: String,
    val ano: Int,
) {

    companion object {
        fun onlyId(id: Long?) = ColecaoDTO(id, "", 0)

    }
}