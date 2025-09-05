package com.aurora.webapi.modules.fichas.adapters.outbound.repositories.artigo

import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ArtigoEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.toDomain
import com.aurora.webapi.modules.fichas.domain.Artigo
import com.aurora.webapi.modules.fichas.domain.toEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class ArtigoRepositoryImpl
    (private val jpaArtigoRepository: JpaArtigoRepository): ArtigoRepository {
    override fun save(artigo: Artigo): Artigo {
        val entity = artigo.toEntity()
        return jpaArtigoRepository.save(entity).toDomain()
    }

    override fun findById(id: Long): Artigo? {
        return jpaArtigoRepository.findById(id).orElseThrow { EntityNotFoundException("artigo naoemcomtrado") }.toDomain()
    }

    override fun findAllByCodigoAndStatus(
        pageable: Pageable,
        termo: String,
        active: StatusEnum
    ): Page<Artigo> {
        return jpaArtigoRepository.findAllByNomeAndStatus(pageable, termo, active).map { it.toDomain() }

    }

    override fun findAllByStatus(
        active: StatusEnum,
        pageable: Pageable
    ): Page<Artigo> {
        return jpaArtigoRepository.findAllByStatus(active, pageable).map { it.toDomain() }

    }

    override fun findAll(): List<Artigo> {
        return jpaArtigoRepository.findAll().map { artigo ->
            artigo.toDomain()
        }
    }

    override fun findAllById(ids: List<Long>): List<Artigo> {
       return jpaArtigoRepository.findAllById(ids).map {
           it -> it.toDomain()
       }
    }

    override fun deleteById(id: Long) {
        jpaArtigoRepository.deleteById(id)
    }

    override fun findAllByNomeAndStatus(
        pageable: Pageable,
        termo: String,
        active: StatusEnum
    ): Page<ArtigoEntity> {
      return jpaArtigoRepository.findAllByNomeAndStatus(
           pageable = pageable,
           nome = termo,
           status = active
       )
    }

}