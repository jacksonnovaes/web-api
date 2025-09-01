package com.aurora.webapi.modules.fichas.application.usecases.colecao

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ColecaoEntity
import com.aurora.webapi.modules.fichas.service.colecao.ColecaoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ListColecao(
    val colecaoService: ColecaoService
) {

    fun execute(page: Int = 0,
                linesPerPage: Int = 100, 
                orderBy: String = "descricao",
                direction: String= "ASC"): Page<ColecaoEntity> {
        val pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return colecaoService.buscarTodos(pageRequest)
    }
}