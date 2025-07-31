package com.aurora.webapi.modules.fichas.infra.entity

import com.fasterxml.jackson.annotation.JsonBackReference
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
    @ManyToOne
    @JoinColumn(name = "id_colecao")
    val colecao: ColecaoEntity,

    @ManyToOne
    @JoinColumn(name = "id_artigo")
    val artigo: ArtigoEntity,
    @ManyToOne
    @JoinColumn(name="id_composicao")
    @JsonBackReference
    val composicao: ComposicaoEntity,
    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    @JsonBackReference
    val fornecedor: FornecedorEntity
)
