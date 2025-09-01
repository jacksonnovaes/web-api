package com.aurora.webapi.modules.fichas.adapters.outbound.entities

import jakarta.persistence.*

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