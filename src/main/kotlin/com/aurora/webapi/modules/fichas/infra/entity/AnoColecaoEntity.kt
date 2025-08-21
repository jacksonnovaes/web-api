package com.aurora.webapi.modules.fichas.infra.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "tb_ano_colecao")
@SequenceGenerator(name = "ano_col_seq", sequenceName = "ano_col_seq", allocationSize = 1)
data class AnoColecaoEntity(

    @Id @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "ano_col_seq")
    @Column(name = "id")
    val id: Long? = null,
    @Column(name = "ano_colecao")
    val ano: String,
)