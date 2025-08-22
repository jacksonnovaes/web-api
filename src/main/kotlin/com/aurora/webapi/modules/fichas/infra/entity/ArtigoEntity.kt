package com.aurora.webapi.modules.fichas.infra.entity

import com.aurora.webapi.modules.fichas.enums.StatusEnum
import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "tb_artigo")
@SequenceGenerator(name = "artigo_seq", sequenceName = "artigo_seq", allocationSize = 1)
data class ArtigoEntity(
    @Id @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "artigo_seq")
    @Column(name = "id")
    val id: Long? = null,
    val nome: String,
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    val status: StatusEnum? = StatusEnum.ACTIVE,
    @ManyToMany
    @JoinTable(
        name = "artigo_lavagem",
        joinColumns = [JoinColumn(name = "id_artigo")],
        inverseJoinColumns = [JoinColumn(name = "id_lavagem")])
    val instrucions: List<LavagemEntity>? = emptyList(),
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonBackReference
    val categotia: CategoriaEntity
)
