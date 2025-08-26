package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.CorDTO
import com.aurora.webapi.modules.fichas.usecases.cor.ListCor
import com.aurora.webapi.modules.fichas.usecases.cor.ListCorByNome
import com.aurora.webapi.modules.fichas.usecases.cor.SaveCor
import com.aurora.webapi.modules.fichas.usecases.cor.UpdateCor
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/cor")
class CorController(
    private val saveCor: SaveCor,
    private val listCor: ListCor,
    private val listCorByNome: ListCorByNome,
    private val updateCor: UpdateCor
){

    @PostMapping( "/salvar")
    fun saveCor(@RequestBody corDTO: CorDTO): CorDTO {
       val cor =  saveCor.execute(corDTO)
        return CorDTO(
            id = cor.id,
            nome = cor.nome,
            valorHex = cor.valorHexadecimal
        )
    }

    @PutMapping( "/update/{id}")
    fun saveCor(@PathVariable id: Long, @RequestBody corDTO: CorDTO): CorDTO {
        val cor =  updateCor.execute(id,corDTO)
        return CorDTO(
            id = cor.id,
            nome = cor.nome,
            valorHex = cor.valorHexadecimal
        )
    }

    @GetMapping("/list")
    fun listCor(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
        @RequestParam(value = "order", defaultValue = "nome") orderBy: String,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String,
    ): ResponseEntity<Page<CorDTO>>{
        val listAll = listCor.execute(page, linesPerPage, orderBy, direction)

        return ResponseEntity.ok(
            listAll.map { cor ->
                CorDTO(
                    cor.id,
                    cor.nome,
                    cor.valorHexadecimal
                )
            }
        )
    }

    @GetMapping("/list/nome/{nome}")
    fun buscaPorNmoe(
        @PathVariable nome: String,
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
        @RequestParam(value = "order", defaultValue = "nome") orderBy: String,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String,
    ): ResponseEntity<Page<CorDTO>>{
        val listAll = listCorByNome.execute(nome, page, linesPerPage, orderBy, direction)

        return ResponseEntity.ok(
            listAll.map { cor ->
                CorDTO(
                    cor.id,
                    cor.nome,
                    cor.valorHexadecimal
                )
            }
        )
    }
}