package com.aurora.webapi.modules.fichas.service.rolo

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.RoloEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.rolo.RoloRepository
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service

class RoloService (
    private val roloRepository: RoloRepository
) : CrudService<RoloEntity> {
    @Transactional
    override fun save(entity: RoloEntity): RoloEntity {
        return roloRepository.save(entity)
    }

    override fun buscarPorId(id: Long): RoloEntity {
        return roloRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Rolo com ID $id não encontrada") }
    }

    override fun buscarTodos(pageable: Pageable): Page<RoloEntity> {

        return roloRepository.findAllByStatus(StatusEnum.ACTIVE, pageable)

    }

    override fun buscarTodos(): List<RoloEntity> {
        return roloRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<RoloEntity> {
        return roloRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
        roloRepository.deleteById(id)
    }

    override fun buscarPorNomeDescricao(
        termo: String,
        status: String,
        pageable: Pageable
    ): Page<RoloEntity> {
        return roloRepository.findAllByCodigoAndStatus(pageable, termo, StatusEnum.ACTIVE)
    }


}