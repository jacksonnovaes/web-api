package com.aurora.webapi.modules.fichas.usecases.cor

import com.aurora.webapi.modules.fichas.enums.StatusEnum
import com.aurora.webapi.modules.fichas.infra.entity.CorEntity
import com.aurora.webapi.modules.fichas.service.cor.CorService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ListCorByNome(
    private val corService: CorService
) {

    fun execute(nome: String, page: Int, linesPerPage: Int, orderBy: String, direction: String): Page<CorEntity> {
        val pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return corService.buscarPorNomeDescricao(nome, StatusEnum.ACTIVE.name,pageRequest)
    }
}