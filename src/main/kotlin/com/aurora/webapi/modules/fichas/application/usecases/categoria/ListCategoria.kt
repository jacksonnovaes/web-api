package com.aurora.webapi.modules.fichas.application.usecases.categoria

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CategoriaEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.CategoriaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ListCategoria(
    val categoriaRepository: CategoriaRepository
)
{

    fun execute(page: Int, linesPerPage: Int, orderBy: String, direction: String): Page<CategoriaEntity>{
        val pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return  categoriaRepository.findAll(pageRequest)
    }
}