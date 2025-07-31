package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.CategoriaDTO
import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.service.categoria.CategoriaService
import com.aurora.webapi.modules.fichas.usecases.categoria.SaveCategoria
import com.aurora.webapi.modules.fichas.usecases.lavagem.SaveLavagem
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
@RestController
@RequestMapping("/api/v1/categoria")
class CategoriaController(
    val saveCategoria: SaveCategoria
) {


    @PostMapping("/save")
    fun saveFicha(@RequestBody categoriaDTO: CategoriaDTO) {
        saveCategoria.execute(categoriaDTO)
    }

}