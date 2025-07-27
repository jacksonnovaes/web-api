package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.ArtigoResponseDTO
import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.LavagenRespondeDTO
import com.aurora.webapi.modules.fichas.usecases.artigo.ListArtigos
import com.aurora.webapi.modules.fichas.usecases.artigo.SaveArtigo
import com.aurora.webapi.modules.fichas.usecases.colecao.ListColecao
import com.aurora.webapi.modules.fichas.usecases.colecao.SaveColecao
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/colecao")
class ColecaoController(
        private val saveColecao: SaveColecao,
        private val listColecao: ListColecao
) {

    @PostMapping("/save")
    fun saveColecao(@RequestBody colecaoDTO: ColecaoDTO) {
        saveColecao.execute(colecaoDTO)
    }
    @GetMapping("/list")
    fun listColecao()
            : ResponseEntity<List<ColecaoDTO>>{

        val listAll = listColecao.execute()


        return ResponseEntity.ok(
            listAll.map { colecao ->
                ColecaoDTO(
                    colecao.id,
                    colecao.nome,
                    colecao.ano)
                     }
        )
    }
}