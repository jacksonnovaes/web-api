package com.aurora.webapi.modules.usuarios.infra.entity

import jakarta.persistence.Embeddable

@Embeddable
data class Role(
    val name: String
)