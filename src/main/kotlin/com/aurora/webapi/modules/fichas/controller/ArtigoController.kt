package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.ArtigoResponseDTO
import com.aurora.webapi.modules.fichas.CategoriaDTO
import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.LavagenRespondeDTO
import com.aurora.webapi.modules.fichas.usecases.artigo.ListArtigos
import com.aurora.webapi.modules.fichas.usecases.artigo.SaveArtigo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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
                    CategoriaDTO(
                        id = artigo.categotia.id,
                        nome = artigo.categotia.nome
                    ),
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

    @PutMapping("/atualizar/{id}")
    fun updateFicha(@PathVariable id: Long, @RequestBody artigoDTO: ArtigoDTO) {
        val artigo = ArtigoDTO(
            id = id,
            nome = artigoDTO.nome,
            instrucoes = artigoDTO.instrucoes,
            categoriaId = artigoDTO.categoriaId
        )
        saveArtigo.execute(artigo)
    }
}