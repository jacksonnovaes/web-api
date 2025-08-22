package com.aurora.webapi.modules.fichas.service.colecao

import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.enums.StatusEnum
import com.aurora.webapi.modules.fichas.infra.entity.ColecaoEntity
import com.aurora.webapi.modules.fichas.infra.repositories.ColecaoRepository
import com.aurora.webapi.modules.fichas.service.CrudService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ColecaoService(
    val colecaoRepository: ColecaoRepository
) : CrudService<ColecaoEntity>{

    override fun save(entity: ColecaoEntity): ColecaoEntity {
        return colecaoRepository.save(entity)
    }

    override fun buscarPorId(id: Long): ColecaoEntity? {
        return colecaoRepository.findById(id).orElseThrow { throw EntityNotFoundException("colecao nao encontrada") }
    }

    override fun buscarTodos(pageable: Pageable): Page<ColecaoEntity> {
        return colecaoRepository.findAll(statusEnum = StatusEnum.ACTIVE, pageable)
    }

    override fun buscarTodos(): List<ColecaoEntity> {
        return colecaoRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<ColecaoEntity> {
        return colecaoRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
        val colecao = buscarPorId(id)
        val colecaoUpdate= ColecaoEntity(
            id = colecao?.id,
            descricao = colecao!!.descricao,
            anoCoelecao = colecao.anoCoelecao,
            fichas = colecao.fichas,
            status = StatusEnum.INACTIVE
        )
        colecaoRepository.save(colecaoUpdate)
    }

    override fun buscarPorNomeDescricao(
        termo: String,
        status: String,
        pageable: Pageable
    ): Page<ColecaoEntity> {
        TODO("Not yet implemented")
    }
}