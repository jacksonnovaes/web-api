package com.aurora.webapi.modules.fichas.infra.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

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