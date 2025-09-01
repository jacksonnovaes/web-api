package com.aurora.webapi.modules.fichas.adapters.outbound.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_cores")
@SequenceGenerator(name = "cores_seq", sequenceName = "cores_seq", allocationSize = 1)
data class CorEntity(

    @Id @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "cores_seq")
    @Column(name = "id")
    val id: Long? = null,
    @Column(name = "nome")
    val nome: String,
    @Column(name = "hexadecimal")
    val valorHexadecimal: String,
)