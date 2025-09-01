package com.aurora.webapi.modules.fichas.adapters.inbound.controller

import com.aurora.webapi.modules.fichas.CategoriaDTO
import com.aurora.webapi.modules.fichas.application.usecases.categoria.ListCategoria
import com.aurora.webapi.modules.fichas.application.usecases.categoria.SaveCategoria
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/categoria")
class CategoriaController(
    val saveCategoria: SaveCategoria,
    val listCategoria: ListCategoria
) {


    @PostMapping("/save")
    fun saveFicha(@RequestBody categoriaDTO: CategoriaDTO) {
        saveCategoria.execute(categoriaDTO)
    }
    @GetMapping("/list")
    fun listCategorias(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
        @RequestParam(value = "order", defaultValue = "nome") orderBy: String,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String,
    ): ResponseEntity<Page<CategoriaDTO>>{
        val response =  listCategoria.execute(
            page, linesPerPage, orderBy, direction
        ).map { it ->
            CategoriaDTO(
                it.id,
                it.nome
            )
        }
        return ResponseEntity.ok(response)
    }
}