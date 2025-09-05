package com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum

enum class MedidasEnum(val value: String) {

    KG("kg"),
    MT("mt");

    companion object {
        fun fromValue(value: String?): MedidasEnum? {
            return entries.find { it.value.equals(value, ignoreCase = true) }
        }
    }
}

