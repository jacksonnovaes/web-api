package com.aurora.webapi.modules.fichas.adapters.outbound.entities

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.domain.Artigo
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
    @ElementCollection
    @CollectionTable(
        name = "artigo_lavagem",
        joinColumns = [JoinColumn(name = "id_artigo")]
    )
    @Column(name = "id_lavagem")
    val instrucions: List<Long>? = emptyList(),
    @Column(name = "id_categoria")
    val categoria: Long?
)
fun ArtigoEntity.toDomain() = Artigo(
    id = this.id,
    nome = this.nome,
    status = this.status!!,
    instrucionsIds = this.instrucions,
    categoriaId = this.categoria!!,
)