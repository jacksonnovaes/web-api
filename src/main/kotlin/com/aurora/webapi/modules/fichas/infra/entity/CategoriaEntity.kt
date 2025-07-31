package com.aurora.webapi.modules.fichas.infra.entity

import jakarta.persistence.*

@Entity
@Table(name = "TB_CATEGORIA")
@SequenceGenerator(name = "categoria_seq", sequenceName = "categoria_seq", allocationSize = 1)

data class CategoriaEntity(
    @Id @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "categoria_seq")
    @Column(name = "id")
    val id: Long? = null,

    val nome: String,
) {

}
