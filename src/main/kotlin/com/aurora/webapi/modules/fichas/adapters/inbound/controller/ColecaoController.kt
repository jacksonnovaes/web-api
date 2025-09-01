package com.aurora.webapi.modules.fichas.adapters.inbound.controller

import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.ColecaoResponseDTO
import com.aurora.webapi.modules.fichas.application.usecases.colecao.ListColecao
import com.aurora.webapi.modules.fichas.application.usecases.colecao.RemoveColecao
import com.aurora.webapi.modules.fichas.application.usecases.colecao.SaveColecao
import com.aurora.webapi.modules.fichas.application.usecases.colecao.UpdateColecao

import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/colecao")
class ColecaoController(
    private val saveColecao: SaveColecao,
    private val listColecao: ListColecao,
    private val updateColecao: UpdateColecao,
    private val removeColecao: RemoveColecao
){

    @PostMapping("/save")
    fun saveColecao(@RequestBody colecaoDTO: ColecaoDTO): ResponseEntity<ColecaoResponseDTO> {
        val result = saveColecao.execute(colecaoDTO)

        return ResponseEntity.ok(result)
    }

    @PutMapping("/update/{id}")
    fun updateColecao(
        @PathVariable id: Long,
        @RequestBody colecaoDTO: ColecaoDTO): ResponseEntity<ColecaoResponseDTO> {
        val result = updateColecao.execute(id,colecaoDTO)

        return ResponseEntity.ok(result)
    }
    @GetMapping("/list")
    fun listColecao(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
        @RequestParam(value = "order", defaultValue = "descricao") orderBy: String,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String,
    )
            : ResponseEntity<Page<ColecaoResponseDTO>>{

        val listAll = listColecao.execute(page, linesPerPage, orderBy, direction)


        return ResponseEntity.ok(
            listAll.map { colecao ->
                ColecaoResponseDTO(
                    colecao.id,
                    colecao.descricao,
                    colecao.anoCoelecao?.ano,
                    colecao.anoCoelecao?.id
                )
                     }
        )
    }

    @DeleteMapping("/remove/{id}")
    fun removeColecao(
        @PathVariable id: Long) {
        removeColecao.execute(id)
    }
}