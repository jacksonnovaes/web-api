package com.aurora.webapi.modules.fichas.adapters.inbound.controller

import com.aurora.webapi.modules.fichas.CategoriaLavagenDTO
import com.aurora.webapi.modules.fichas.application.usecases.lavagem.ListCategoriaLavagem

import com.aurora.webapi.modules.fichas.application.usecases.lavagem.SaveCategoriaLavagem
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1/lavagemCategoria")
class CategoriaLavagemController(
    val listCategoriaLavagem: ListCategoriaLavagem,
    val saveCategoriaLavagem: SaveCategoriaLavagem
) {


    @PostMapping("/save")
    fun saveFicha(
                @RequestBody categoriaLavagem: CategoriaLavagenDTO
    ) {
        saveCategoriaLavagem.execute(categoriaLavagem)
    }
    @GetMapping("/listAll")
    fun listCategoriaLavagem(
    ): ResponseEntity<List<CategoriaLavagenDTO>> {
       val response = listCategoriaLavagem.execute().map { it ->
            CategoriaLavagenDTO(
                it.id,
                it.descricao
            )
        }
        return ResponseEntity.ok(response)
    }



}