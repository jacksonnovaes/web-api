package com.aurora.webapi.modules.fichas.adapters.inbound.controller

import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.LavagenResponseDTO
import com.aurora.webapi.modules.fichas.application.usecases.lavagem.ListLavagem
import com.aurora.webapi.modules.fichas.application.usecases.lavagem.SaveLavagem
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/v1/lavagem")
class LavagemController(
    val saveLavagem: SaveLavagem,
    val listLavagem: ListLavagem
) {


    @OptIn(ExperimentalUnsignedTypes::class)
    @PostMapping("/save/{id}")
    fun saveFicha(@RequestParam descricao: String,
                  @RequestParam code: Int,
                  @RequestParam imagem: MultipartFile,
                  @PathVariable  id: Long
    ) {
        val lavagem = LavagenDTO(
            descricao = descricao,
            code = code,
            imagem = imagem.bytes,
            lavagemCategoriaID = id
        )
        saveLavagem.execute(lavagem, imagem)
    }

    @PostMapping("/multiple/{id}/save", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun saveInstruoesa(
        @RequestParam("files") imagens: Array<MultipartFile>,
        @PathVariable id: Long
    ): ResponseEntity<List<LavagenDTO>> {

        val blocos = imagens.asList().chunked(8)

        val lavagensSalvas = mutableListOf<LavagenDTO>()

        blocos.forEach { bloco ->
            bloco.forEachIndexed { index, file ->
                val lavagem = LavagenDTO(
                    descricao = file.name,
                    code = index + 1,
                    imagem = file.bytes,
                    lavagemCategoriaID = id
                )

                val saved = saveLavagem.execute(lavagem, file)

                val response = LavagenDTO(
                    saved.id,
                    saved.descricao,
                    saved.code,
                    saved.imagem,
                    lavagemCategoriaID = saved.categoria?.id
                )

                lavagensSalvas.add(response)
            }
        }

        return ResponseEntity.ok(lavagensSalvas)
    }


    @GetMapping("/listAll")
    fun listInstrucoes(): ResponseEntity<List<LavagenResponseDTO>?> {
        val instrucoes = listLavagem.execute()

        val response = instrucoes.map { it
            LavagenResponseDTO(
                it.id,
                it.descricao,
                code = it.code,
                imagem = it.imagem,
                lavagemCategoria= it.categoria?.descricao
            )
        }
        return ResponseEntity.ok(response)
    }
}