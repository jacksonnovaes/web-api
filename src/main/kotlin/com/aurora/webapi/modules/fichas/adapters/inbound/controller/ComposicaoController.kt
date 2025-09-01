package com.aurora.webapi.modules.fichas.adapters.inbound.controller

import com.aurora.webapi.modules.fichas.ComposicaoDTO
import com.aurora.webapi.modules.fichas.application.usecases.composicao.ListComposicao
import com.aurora.webapi.modules.fichas.application.usecases.composicao.SaveComposicao
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/composicao")
class ComposicaoController(
    val saveComposicao: SaveComposicao,
    val listComposicao: ListComposicao
) {

    @PostMapping("/save")
    fun saveFicha(@RequestBody @Valid composicaoDTO: ComposicaoDTO) {
        saveComposicao.execute(composicaoDTO)
    }
    @GetMapping("/list")
    fun listArtigos()
            : ResponseEntity<List<ComposicaoDTO>>{
        val listAll = listComposicao.execute()

        return ResponseEntity.ok(
            listAll.map { composicao ->
                ComposicaoDTO(
                    composicao.id,
                    composicao.descricao
            )
        })
    }
}