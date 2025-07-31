package com.aurora.webapi.modules.fichas.infra.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "tb_colecao")
@SequenceGenerator(name = "colecao_seq", sequenceName = "colecao_seq", allocationSize = 1)
data class ColecaoEntity(

    @Id @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "colecao_seq")
    @Column(name = "id")
    val id: Long? = null,
    @Column(name = "descricao")
    val nome: String,
    @Column(name = "ano_colecao")
    val ano: Int,
    @JsonIgnore
    @OneToMany(mappedBy = "colecao")
    val fichas: List<FichaEntity> = emptyList()
) {

}
