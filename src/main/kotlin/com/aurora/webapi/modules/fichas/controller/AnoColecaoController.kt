package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.AnoColecaoDTO
import com.aurora.webapi.modules.fichas.AnoColecaoResponseDTO
import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.ColecaoResponseDTO
import com.aurora.webapi.modules.fichas.usecases.colecao.ListAnoColecao
import com.aurora.webapi.modules.fichas.usecases.colecao.ListColecao
import com.aurora.webapi.modules.fichas.usecases.colecao.SaveAnoColecao
import com.aurora.webapi.modules.fichas.usecases.colecao.SaveColecao
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/anoColecao")
class AnoColecaoController(
        private val listAnoColecao: ListAnoColecao,
        private val saveAnoColecao: SaveAnoColecao
) {

    @PostMapping("/save")
    fun saveColecao(@RequestBody colecaoDTO: AnoColecaoDTO): ResponseEntity<AnoColecaoResponseDTO> {
        val result = saveAnoColecao.execute(colecaoDTO)

        return ResponseEntity.ok(result)
    }
    @GetMapping("/list")
    fun listAnoColecao()
            : ResponseEntity<List<AnoColecaoDTO>>{

        val listAll = listAnoColecao.execute()


        return ResponseEntity.ok(
            listAll.map { colecao ->
                AnoColecaoDTO(
                    colecao.id,
                    colecao.ano,
                )
                     }
        )
    }
}