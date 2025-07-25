package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.usecases.ListAllFichas
import com.aurora.webapi.modules.fichas.usecases.SaveFicha
import com.aurora.webapi.utils.PageResponse
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import toPageResponse

@RestController
    @RequestMapping("/v1/fichas")
class FichaController(
    private final val saveFicha: SaveFicha,
    private final val listAllFichas: ListAllFichas
) {

    @PostMapping("/save")
    fun saveFicha(@RequestBody fichaDTO: FichaDTO) {
        saveFicha.execute(fichaDTO)
    }

    @GetMapping("/list")
    fun getListAllFichs(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
        @RequestParam(value = "order", defaultValue = "dataEntrada") orderBy: String,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String)
    : ResponseEntity<PageResponse<FichaDTO>>{

       val listAll = listAllFichas.execute(page, linesPerPage, orderBy, direction)


        return ResponseEntity.ok(listAll.toPageResponse())
    }

}