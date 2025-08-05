package com.aurora.webapi.modules.fichas

data class ComposicaoDTO(
    val id: Long?,

    val descricao: String="",

) {
    companion object {
        fun onlyId(id: Long?) = ComposicaoDTO(id, "")
    }
}