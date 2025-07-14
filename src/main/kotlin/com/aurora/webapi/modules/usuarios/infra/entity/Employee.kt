package com.aurora.webapi.modules.usuarios.infra.entity

import jakarta.persistence.Entity

@Entity
class Employee(
    id: Long? = null,
    nome: String,
    lastName: String,
    documentId: String,
    userId: Long?
) : Person(id, nome, lastName, documentId, userId)


