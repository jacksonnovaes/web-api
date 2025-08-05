package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.CategoriaDTO
import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.service.categoria.CategoriaService
import com.aurora.webapi.modules.fichas.usecases.categoria.ListCategoria
import com.aurora.webapi.modules.fichas.usecases.categoria.SaveCategoria
import com.aurora.webapi.modules.fichas.usecases.lavagem.SaveLavagem
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
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
    fun listCategorias(): ResponseEntity<List<CategoriaDTO>>{
        val response =  listCategoria.execute().map { it ->
            CategoriaDTO(
                it.id,
                it.nome
            )
        }
        return ResponseEntity.ok(response)
    }
}