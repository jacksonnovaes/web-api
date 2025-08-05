package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.CategoriaLavagenDTO
import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.infra.entity.CategoriaLavagemEntity
import com.aurora.webapi.modules.fichas.service.lavagem.CategoriaLagameService
import com.aurora.webapi.modules.fichas.usecases.lavagem.ListLavagem
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
@RequestMapping("/v1/lavagemCategoria")
class CategoriaLavagemController(
        val categoriaLagameService: CategoriaLagameService
) {


    @PostMapping("/save")
    fun saveFicha(
                @RequestBody dto: CategoriaLavagenDTO
    ) {
        val lavagem = CategoriaLavagemEntity(
            id = null,
            descricao = dto.descricao
        )
        categoriaLagameService.save(lavagem)
    }
    @GetMapping("/listAll")
    fun listCategoriaLavagem(): List<CategoriaLavagenDTO> {
       return categoriaLagameService.buscarTodos().map { it ->
            CategoriaLavagenDTO(
                it.id,
                it.descricao
            )
        }
    }



}