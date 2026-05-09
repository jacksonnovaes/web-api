package com.aurora.webapi.modules.fichas.adapters.outbound.entities

import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.FichaReponseDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "tb_ficha")@SequenceGenerator(name = "ficha_seq", sequenceName = "ficha_seq", allocationSize = 1)
data class FichaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ficha_seq")
    @Column(name = "id")
    val id: Long? = null,
    @Column(name = "nr_ficha")
    val numeroFicha: String,
    @Column(name = "nota_fiscal")
    val notaFiscal: String,
    @Column(name = "dt_entrada")
    val dataEntrada: LocalDate?,
    @Column(name = "dt_registro")
    val dataRegistro: LocalDateTime = LocalDateTime.now(),
    @Column(name = "largura")
    val largura: Float,
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    val status: StatusEnum = StatusEnum.ACTIVE,
    @Column(name = "id_colecao")
    val colecao: Long?,
    @Column(name = "id_artigo")
    val artigo: Long?,
    @Column(name="id_composicao")
    val composicao: Long?,
    @Column(name = "id_fornecedor")
    val fornecedor: Long?
)


fun FichaEntity.toDTO() = FichaDTO(
    id = this.id,
    numeroFicha = this.numeroFicha.toInt(),
    notaFiscal = this.notaFiscal.toInt(),
    dataEntrada = this.dataEntrada,
    largura = this.largura,
    artigoId = this.artigo,
    status = this.status?.name ?: "",
    colecaoId = this.colecao,
    composicaoId = this.composicao,
    fornecedorId = this.composicao
)
