package com.aurora.webapi.modules.fichas.service.artigo

import com.aurora.webapi.modules.fichas.enums.StatusEnum
import com.aurora.webapi.modules.fichas.infra.entity.ArtigoEntity
import com.aurora.webapi.modules.fichas.infra.repositories.ArtigoRepository
import com.aurora.webapi.modules.fichas.service.CrudService
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service

class ArtigoService (
    private val artigoRepository: ArtigoRepository
) : CrudService<ArtigoEntity> {
    @Transactional
    override fun save(entity: ArtigoEntity): ArtigoEntity {
        return artigoRepository.save(entity)
    }

    override fun buscarPorId(id: Long): ArtigoEntity {
        return artigoRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Artigo com ID $id não encontrada") }
    }

    override fun buscarTodos(pageable: Pageable): Page<ArtigoEntity> {

        return artigoRepository.findAllByStatus(StatusEnum.ACTIVE, pageable)

    }

    override fun buscarTodos(): List<ArtigoEntity> {
        return artigoRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<ArtigoEntity> {
        return artigoRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
        artigoRepository.deleteById(id)
    }

    override fun buscarPorNomeDescricao(
        termo: String,
        status: String,
        pageable: Pageable
    ): Page<ArtigoEntity> {
        return artigoRepository.findAllByNomeAndStatus(pageable, termo, StatusEnum.ACTIVE)
    }


}