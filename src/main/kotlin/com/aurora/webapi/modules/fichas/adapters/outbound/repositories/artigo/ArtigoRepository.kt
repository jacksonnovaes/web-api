package com.aurora.webapi.modules.fichas.adapters.outbound.repositories.artigo

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.domain.Artigo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ArtigoRepository {
    fun save(artigo: Artigo): Artigo
    fun findById(id: Long): Artigo?
    fun findAllByCodigoAndStatus(pageable: Pageable, termo: String, active: StatusEnum): Page<Artigo>
    fun findAllByStatus(active: StatusEnum, pageable: Pageable): Page<Artigo>
    fun findAll(): List<Artigo>
    fun findAllById(ids: List<Long>): List<Artigo>
    fun deleteById(id: Long)
    fun findAllByNomeAndStatus(pageable: org.springframework.data.domain.Pageable, termo: String, active: com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum): org.springframework.data.domain.Page<com.aurora.webapi.modules.fichas.adapters.outbound.entities.ArtigoEntity>


}