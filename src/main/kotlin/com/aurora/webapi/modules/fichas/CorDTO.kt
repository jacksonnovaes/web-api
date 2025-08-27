package com.aurora.webapi.modules.fichas

data class CorDTO(
    val id: Long?,
    val nome: String,
    val valorHex: String
)
{
    companion object {
            fun onlyId(id: Long?) = CorDTO(id, "", "")
        }
}
