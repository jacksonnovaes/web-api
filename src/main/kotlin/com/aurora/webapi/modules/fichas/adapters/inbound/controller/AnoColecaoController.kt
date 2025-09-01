package com.aurora.webapi.modules.fichas.adapters.inbound.controller

import com.aurora.webapi.modules.fichas.AnoColecaoDTO
import com.aurora.webapi.modules.fichas.AnoColecaoResponseDTO
import com.aurora.webapi.modules.fichas.adapters.inbound.dto.AnoColecaoRequestDTO
import com.aurora.webapi.modules.fichas.application.usecases.anoColecao.impl.ListAnoColecaoImpl
import com.aurora.webapi.modules.fichas.application.usecases.anoColecao.impl.SaveAnoColecaoImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/anoColecao")
class AnoColecaoController(
    private val listAnoColecao: ListAnoColecaoImpl,
    private val saveAnoColecao: SaveAnoColecaoImpl
) {

    @PostMapping("/save")
    fun saveColecao(@RequestBody colecaoDTO: AnoColecaoRequestDTO): ResponseEntity<AnoColecaoResponseDTO> {
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