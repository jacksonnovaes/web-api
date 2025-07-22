package com.aurora.webapi.modules.fichas.infra.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "tb_fornecedor")@SequenceGenerator(name = "fornecedor_seq", sequenceName = "fornecedor_seq", allocationSize = 1)
data class FornecedorEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ficha_seq")
    val id: Long? =  null,
    val nome: String,
    @OneToMany(mappedBy = "fornecedor")
    val fichas: List<FichaEntity>
)
