package com.aurora.webapi.modules.fichas.adapters.inbound.controller

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.ArtigoResponseDTO
import com.aurora.webapi.modules.fichas.CategoriaDTO
import com.aurora.webapi.modules.fichas.LavagenRespondeDTO
import com.aurora.webapi.modules.fichas.application.usecases.artigo.BuscaArtigoByName
import com.aurora.webapi.modules.fichas.application.usecases.artigo.ListArtigos
import com.aurora.webapi.modules.fichas.application.usecases.artigo.RemoverArtigo
import com.aurora.webapi.modules.fichas.application.usecases.artigo.SaveArtigo
import com.aurora.webapi.utils.PageResponse
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import toPageResponse

@RestController
@RequestMapping("/v1/artigos")
class ArtigoController(
    private final val saveArtigo: SaveArtigo,
    private final val listArtigos: ListArtigos,
    private final val removerArtigo: RemoverArtigo,
    private final val buscaArtigoByName: BuscaArtigoByName


) {

    @PostMapping("/save")
    fun saveFicha(@RequestBody artigoDTO: ArtigoDTO) {
        saveArtigo.execute(artigoDTO)
    }

    @DeleteMapping("/remove/{id}")
    fun removeFicha(@PathVariable id: Long) {
        removerArtigo.execute(id)
    }

    @GetMapping("/list")
    fun listArtigos(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
        @RequestParam(value = "order", defaultValue = "nome") orderBy: String,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String,
    )
            : ResponseEntity<PageResponse<ArtigoResponseDTO?>?> {

        val listAll = listArtigos.execute(page, linesPerPage, orderBy, direction)


        return ResponseEntity.ok(
            listAll.map { artigo ->
                ArtigoResponseDTO(
                    artigo.id,
                    artigo.nome,
                    CategoriaDTO(
                        id = artigo.categotia.id,
                        nome = artigo.categotia.nome
                    ),
                    artigo.instrucions?.map {
                        it
                        LavagenRespondeDTO(
                            id = it.id,
                            descricao = it.descricao,
                            code = it.code,
                            imagem = it.imagem
                        )
                    },
                    status = artigo.status?.value
                )
            }.toPageResponse())
    }

    @GetMapping("/search/{nome}")
    fun searchArtigos(
        @PathVariable nome: String,
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
        @RequestParam(value = "order", defaultValue = "nome") orderBy: String,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String,
    )
            : ResponseEntity<Page<ArtigoResponseDTO>> {

        val listAll = buscaArtigoByName.execute(nome,page, linesPerPage, orderBy, direction)


        return ResponseEntity.ok(
            listAll.map { artigo ->
                ArtigoResponseDTO(
                    artigo.id,
                    artigo.nome,
                    CategoriaDTO(
                        id = artigo.categotia.id,
                        nome = artigo.categotia.nome
                    ),
                    artigo.instrucions?.map {
                        it
                        LavagenRespondeDTO(
                            id = it.id,
                            descricao = it.descricao,
                            code = it.code,
                            imagem = it.imagem
                        )
                    },
                    status = artigo.status?.value
                )
            })
    }

    @PutMapping("/atualizar/{id}")
    fun updateFicha(@PathVariable id: Long, @RequestBody artigoDTO: ArtigoDTO) {
        val artigo = ArtigoDTO(
            id = id,
            nome = artigoDTO.nome,
            instrucoes = artigoDTO.instrucoes,
            categoriaId = artigoDTO.categoriaId,
            status = artigoDTO.status
        )
        saveArtigo.execute(artigo)
    }
}