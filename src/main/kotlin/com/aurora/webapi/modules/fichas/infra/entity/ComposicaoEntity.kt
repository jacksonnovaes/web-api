package com.aurora.webapi.modules.fichas.infra.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "tb_composicao")@SequenceGenerator(name ="composicao_seq", sequenceName = "composicao_seq", allocationSize = 1)
data class ComposicaoEntity(
    @Id @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "composicao_seq")
    @Column(name = "id_composicao")
    val id: Long? = null,
    @Column(name = "descricao")
    val descricao: String,
    @Column(name = "cor")
    val cor: String,
    @JsonIgnore
    @OneToMany(mappedBy = "composicao", cascade = [CascadeType.ALL])
    val fichas: List<FichaEntity> = emptyList()
) {

}
