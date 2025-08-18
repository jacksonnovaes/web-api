package com.aurora.webapi.modules.fichas.enums

enum class StatusEnum(val codigo: Int, val description: String) {
    ACTIVE(1, "ativo"),
    INACTIVE(0, "desativado")
}