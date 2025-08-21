package com.aurora.webapi.modules.fichas.enums

enum class StatusEnum(val codigo: Int, val value: String) {
    ACTIVE(1, "ativo"),
    INACTIVE(0, "desativado");

    companion object {
        fun fromValue(value: String?): StatusEnum? {
            return entries.find { it.value.equals(value, ignoreCase = true) }
        }

        fun fromCodigo(codigo: Int): StatusEnum? {
            return entries.find { it.codigo == codigo }
        }
    }
}

