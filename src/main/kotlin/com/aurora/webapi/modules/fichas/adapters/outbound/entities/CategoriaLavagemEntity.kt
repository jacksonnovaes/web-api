package com.aurora.webapi.modules.fichas.adapters.outbound.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_categoria_lavagem")
@SequenceGenerator(name = "categoria_seq", sequenceName = "categoria_seq", allocationSize = 1)

data class CategoriaLavagemEntity(

    @Id @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "categoria_seq")
    @Column(name = "id")
    val id: Long? = null,
    val descricao: String,

)
