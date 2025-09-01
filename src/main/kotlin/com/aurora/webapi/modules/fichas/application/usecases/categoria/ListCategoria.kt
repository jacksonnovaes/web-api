package com.aurora.webapi.modules.fichas.application.usecases.categoria

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CategoriaEntity
import com.aurora.webapi.modules.fichas.service.categoria.CategoriaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ListCategoria(
    val categoriaService: CategoriaService
)
{

    fun execute(page: Int, linesPerPage: Int, orderBy: String, direction: String): Page<CategoriaEntity>{
        val pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return  categoriaService.buscarTodos(pageRequest)
    }
}