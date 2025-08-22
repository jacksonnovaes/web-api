package com.aurora.webapi.modules.fichas.infra.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "tb_categoria_lavagem")
@SequenceGenerator(name = "categoria_seq", sequenceName = "categoria_seq", allocationSize = 1)

data class CategoriaLavagemEntity(

    @Id @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "categoria_seq")
    @Column(name = "id")
    val id: Long? = null,
    val descricao: String,

)
