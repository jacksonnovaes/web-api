package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.ColecaoResponseDTO
import com.aurora.webapi.modules.fichas.usecases.colecao.ListColecao
import com.aurora.webapi.modules.fichas.usecases.colecao.SaveColecao
import com.aurora.webapi.modules.fichas.usecases.colecao.UpdateColecao
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/colecao")
class ColecaoController(
        private val saveColecao: SaveColecao,
        private val listColecao: ListColecao,
        private val updateColecao: UpdateColecao
) {

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
    fun listColecao()
            : ResponseEntity<List<ColecaoResponseDTO>>{

        val listAll = listColecao.execute()


        return ResponseEntity.ok(
            listAll.map { colecao ->
                ColecaoResponseDTO(
                    colecao.id,
                    colecao.descricao,
                    colecao.anoCoelecao?.ano
                )
                     }
        )
    }
}