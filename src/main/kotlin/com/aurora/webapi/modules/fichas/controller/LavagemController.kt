package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.usecases.lavagem.SaveLavagem
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.Base64

@RestController
@RequestMapping("/api/v1/lavagem")
class LavagemController(
    val saveLavagem: SaveLavagem
) {


    @PostMapping("/save")
    fun saveFicha(@RequestParam descricao: String,
                  @RequestParam code: Int,
                  @RequestParam imagem: MultipartFile
    ) {
        val lavagem = LavagenDTO(
            descricao = descricao,
            code = code,
            imagem = imagem.bytes
        )
        saveLavagem.execute(lavagem)
    }

}