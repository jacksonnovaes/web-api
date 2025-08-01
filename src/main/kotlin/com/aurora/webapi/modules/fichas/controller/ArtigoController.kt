package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.ArtigoResponseDTO
import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.LavagenRespondeDTO
import com.aurora.webapi.modules.fichas.usecases.artigo.ListArtigos
import com.aurora.webapi.modules.fichas.usecases.artigo.SaveArtigo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/artigos")
class ArtigoController(
    private final val saveArtigo: SaveArtigo,
    private final val listArtigos: ListArtigos
) {

    @PostMapping("/save")
    fun saveFicha(@RequestBody artigoDTO: ArtigoDTO) {
        saveArtigo.execute(artigoDTO)
    }
    @GetMapping("/list")
    fun listArtigos()
            : ResponseEntity<List<ArtigoResponseDTO>>{

        val listAll = listArtigos.execute()


        return ResponseEntity.ok(
            listAll.map { artigo ->
                ArtigoResponseDTO(
                    artigo.id,
                    artigo.nome,
                    artigo.instrucions?.map { it
                        LavagenRespondeDTO(
                            id=it.id,
                            descricao = it.descricao,
                            code = it.code,
                            imagem = it.imagem
                        )
                    }
            )
        })
    }
}