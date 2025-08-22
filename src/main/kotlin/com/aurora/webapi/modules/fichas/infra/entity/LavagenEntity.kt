package com.aurora.webapi.modules.fichas.infra.entity

import jakarta.persistence.*

@Entity
@Table(name = "tb_lavagem")
@SequenceGenerator(name = "lavagem_seq", sequenceName = "lavagem_seq", allocationSize = 1)
data class LavagemEntity(
    @Id @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "lavagem_seq")
    @Column(name = "id_lavagem")
    val id: Long? = null,
    val descricao: String,
    val code: Int,
    @Column(name = "imagem", columnDefinition = "bytea")
    val imagem: ByteArray?,
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    val categoria: CategoriaLavagemEntity?
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LavagemEntity

        if (id != other.id) return false
        if (code != other.code) return false
        if (descricao != other.descricao) return false
        if (!imagem.contentEquals(other.imagem)) return false
        if (categoria != other.categoria) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + code
        result = 31 * result + descricao.hashCode()
        result = 31 * result + imagem.contentHashCode()
        result = 31 * result + categoria.hashCode()
        return result
    }
}
