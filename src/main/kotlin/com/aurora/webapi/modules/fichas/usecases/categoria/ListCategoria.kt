package com.aurora.webapi.modules.fichas.usecases.categoria

import com.aurora.webapi.modules.fichas.CategoriaDTO
import com.aurora.webapi.modules.fichas.infra.entity.CategoriaEntity
import com.aurora.webapi.modules.fichas.service.categoria.CategoriaService
import org.springframework.stereotype.Service

@Service
class ListCategoria(
    val categoriaService: CategoriaService
)
{

    fun execute(): List<CategoriaEntity>{
        return  categoriaService.buscarTodos()
    }
}