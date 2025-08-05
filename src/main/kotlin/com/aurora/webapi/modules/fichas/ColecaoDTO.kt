package com.aurora.webapi.modules.fichas

data class ColecaoDTO(
    val id: Long? =null,
    val nome: String = "",
    val anoColecaoId: Long?,
) {

    companion object {
        fun onlyId(id: Long?) = ColecaoDTO(id, "", null)

    }
}
    data class ColecaoResponseDTO(
        val id: Long? =null,
        val nome: String = "",
        val ano: String?,
    )