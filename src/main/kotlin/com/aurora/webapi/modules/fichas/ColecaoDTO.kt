package com.aurora.webapi.modules.fichas

data class ColecaoDTO(
    val id: Long? =null,
    val nome: String = "",
    val anoColecaoId: Long?,
    val status: String?
) {

    companion object {
        fun onlyId(id: Long?) = ColecaoDTO(id, "", null, status = "")

    }
}
    data class ColecaoResponseDTO(
        val id: Long? =null,
        val nome: String = "",
        val ano: String?,
        val anoColecaoId: Long?,
    )