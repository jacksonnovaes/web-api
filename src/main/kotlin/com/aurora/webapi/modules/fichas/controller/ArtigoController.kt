package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.usecases.ListAllFichas
import com.aurora.webapi.modules.fichas.usecases.SaveArtigo
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
@RequestMapping("/v1/artigos")
class ArtigoController(
    private final val saveArtigo: SaveArtigo,
) {

    @PostMapping("/save")
    fun saveFicha(@RequestBody artigoDTO: ArtigoDTO) {
        saveArtigo.execute(artigoDTO)
    }

}