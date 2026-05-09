package com.aurora.webapi.modules.fichas.infra.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "tb_rolo")
@SequenceGenerator(name = "rolo_seq", sequenceName = "rolo_seq", allocationSize = 1)
data class RoloEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolo_seq")
    @Column(name = "id")
    val id: Long? = null,
    val codigoRolo: Int? = null,
    val metros: Float,
    val kilos: Float,
    val rendimento: Float,
    val localizacao: String,
    @ManyToOne
    @JoinColumn(name="id_ficha")
    val ficha: FichaEntity,

    )