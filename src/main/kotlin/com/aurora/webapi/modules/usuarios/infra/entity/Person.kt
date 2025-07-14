package com.aurora.webapi.modules.usuarios.infra.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "TB_PERSON")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 1)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
open class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    val id: Long? = null,
    val nome: String,
    val lastName: String,
    val documentId: String,
    val userId: Long? = null
)
