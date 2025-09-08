package com.aurora.webapi.modules.fichas.adapters.outbound.entities


import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.domain.Artigo
import com.aurora.webapi.modules.fichas.domain.Rolo
import jakarta.persistence.*

@Entity
@Table(name = "tb_rolo")
@SequenceGenerator(name = "rolo_seq", sequenceName = "rolo_seq", allocationSize = 1)
data class RoloEntity(

    @Id @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "rolo_seq")
    @Column(name = "id")
    val id: Long? = null,
    @Column(name = "codigo")
    val codigo: Long,
    @Column(name = "localizacao")
    val localizacao: String,
    @Embedded
    val medidas: Medidas,
    @ManyToOne
    val cor: CorEntity,

    val fichaId: Long,

    val status: StatusEnum
)

fun RoloEntity.toDomain() = Rolo(
    id = this.id,
    codigo = this.codigo,
    localizacao = this.localizacao,
    medidas = this.medidas,
    cor = this.cor,
    fichaId = this.fichaId,
    status = this.status,
)