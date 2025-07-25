package com.aurora.webapi.modules.fichas.infra.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinColumns
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "tb_artigo")
@SequenceGenerator(name = "artigo_seq", sequenceName = "artigo_seq", allocationSize = 1)
data class ArtigoEntity(
    @Id @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "artigo_seq")
    @Column(name = "id_artigo")
    val id: Long? = null,
    val nome: String,
    @ManyToMany
    @JoinTable(
        name = "artigo_lavagem",
        joinColumns = [JoinColumn(name = "id_artigo")],
        inverseJoinColumns = [JoinColumn(name = "id_lavagem")])
    val instrucions: List<LavagenEntity>? = emptyList()
)
