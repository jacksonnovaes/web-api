package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.ArtigoResponseDTO
import com.aurora.webapi.modules.fichas.ComposicaoDTO
import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.LavagenRespondeDTO
import com.aurora.webapi.modules.fichas.usecases.artigo.ListArtigos
import com.aurora.webapi.modules.fichas.usecases.artigo.SaveArtigo
import com.aurora.webapi.modules.fichas.usecases.composicao.ListComposicao
import com.aurora.webapi.modules.fichas.usecases.composicao.SaveComposicao
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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