package com.aurora.webapi.modules.fichas.infra.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "tb_ficha")@SequenceGenerator(name = "ficha_seq", sequenceName = "ficha_seq", allocationSize = 1)
data class FichaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ficha_seq")
    @Column(name = "id_ficha")
    val id: Long? = null,
    @Column(name = "nr_ficha")
    val numeroFicha: String,
    @Column(name = "nota_fiscal")
    val notaFiscal: String,
    @Column(name = "dt_entrada")
    val dataEntrada: LocalDate,
    @ManyToOne
    @JoinColumn(name = "id_colecao")
    val colecao: ColecaoEntity,
    @ManyToOne
    @JoinColumn(name="id_composicao")
    val composicao: ComposicaoEntity,
    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    val fornecedor: FornecedorEntity? = null
)
