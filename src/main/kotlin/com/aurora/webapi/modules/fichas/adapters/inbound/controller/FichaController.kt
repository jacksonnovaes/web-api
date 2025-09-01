package com.aurora.webapi.modules.fichas.adapters.inbound.controller

import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.FichaReponseDTO
import com.aurora.webapi.modules.fichas.application.usecases.fichas.*
import com.aurora.webapi.utils.PageResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import toPageResponse

@RestController
@RequestMapping("/v1/fichas")
class FichaController(
    private final val saveFicha: SaveFicha,
    private final val updateFicha: UpdateFicha,
    private final val removeFicha: RemoveFicha,
    private final val listAllFichas: ListAllFichas,
    private final val findAllFichasByArtigo: FindAllFichasByArtigo
) {

    @PostMapping("/save")
    fun saveFicha(@RequestBody fichaDTO: FichaDTO) {
        saveFicha.execute(fichaDTO)
    }

    @GetMapping("/list")
    fun getListAllFichs(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
        @RequestParam(value = "order", defaultValue = "dt_entrada") orderBy: String,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String)
    : ResponseEntity<PageResponse<FichaReponseDTO>>{

       val listAll = listAllFichas.execute(page, linesPerPage, orderBy, direction)


        return ResponseEntity.ok(listAll.toPageResponse())
    }

    @PutMapping("/update/{id}")
    fun saveFicha(
            @PathVariable id: Long,
            @RequestBody fichaDTO: FichaDTO) {
        updateFicha.execute(id = id, fichaDTO = fichaDTO)
    }

    @DeleteMapping("/remove/{id}")
    fun removeFicha(
        @PathVariable id: Long,
       ) {
        removeFicha.execute(id = id)
    }
    @GetMapping("/search/{nome}")
    fun getlFichsByName(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
        @RequestParam(value = "order", defaultValue = "dt_entrada") orderBy: String,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String,
        @PathVariable nome: String)
            : ResponseEntity<PageResponse<FichaReponseDTO>>{

            val listAll = findAllFichasByArtigo.execute(nome,page, linesPerPage, orderBy, direction)


        return ResponseEntity.ok(listAll.toPageResponse())
    }
}