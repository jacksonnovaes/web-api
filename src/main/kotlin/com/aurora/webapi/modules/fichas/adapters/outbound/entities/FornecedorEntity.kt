package com.aurora.webapi.modules.fichas.adapters.outbound.entities

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "tb_fornecedor")@SequenceGenerator(name = "fornecedor_seq", sequenceName = "fornecedor_seq", allocationSize = 1)
data class FornecedorEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor_seq")
    val id: Long? =  null,
    val nome: String,
    @JsonManagedReference
    @OneToMany(mappedBy = "fornecedor")
    val fichas: List<FichaEntity>,
    @Enumerated(EnumType.STRING)
    val status: StatusEnum = StatusEnum.ACTIVE
)
