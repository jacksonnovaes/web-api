package com.aurora.webapi.modules.fichas

data class AnoColecaoDTO(
    val id: Long?=null,
    val nome: String = "",
) {

    companion object {
        fun onlyId(id: Long?) = AnoColecaoDTO(id, "")

    }
}
data class AnoColecaoResponseDTO(
    val id: Long?=null,
    val ano: String = "",
)
