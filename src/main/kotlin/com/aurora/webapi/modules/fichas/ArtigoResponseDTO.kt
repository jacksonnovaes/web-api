package com.aurora.webapi.modules.fichas

import com.aurora.webapi.modules.fichas.enums.StatusEnum

data class ArtigoResponseDTO(
    val id: Long? = null,
    val nome: String,
    val categoriaDTO: CategoriaDTO,
    val instrucoes: List<LavagenRespondeDTO>? = emptyList(),
    val status: StatusEnum?

    )
data class LavagenRespondeDTO(
    val id: Long? = null,
    val descricao: String,
    val code: Int,
    val imagem: ByteArray?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LavagenRespondeDTO

        if (id != other.id) return false
        if (code != other.code) return false
        if (descricao != other.descricao) return false
        if (!imagem.contentEquals(other.imagem)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + code
        result = 31 * result + descricao.hashCode()
        result = 31 * result + imagem.hashCode()
        return result
    }
}
