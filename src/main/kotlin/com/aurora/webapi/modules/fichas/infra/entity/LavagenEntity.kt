package com.aurora.webapi.modules.fichas.infra.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "tb_lavagem")
@SequenceGenerator(name = "lavagem_seq", sequenceName = "lavagem_seq", allocationSize = 1)
data class LavagenEntity(
    @Id @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "lavagem_seq")
    @Column(name = "id_lavagem")
    val id: Long? = null,
    val descricao: String,
    val code: Int,
    val image: String
) {

}
