package com.aurora.webapi.modules.fichas.application.usecases.lavagem

import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CategoriaLavagemEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.LavagemEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.CategoriaLagamRepository
import com.aurora.webapi.modules.fichas.service.lavagem.LavagenService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class SaveLavagem(
    val lavagemService: LavagenService,
    val categoriaLagamRepository: CategoriaLagamRepository
) {
    fun execute(lavagenDTO: LavagenDTO, file: MultipartFile): LavagemEntity {
        val categoria = lavagenDTO.lavagemCategoriaID?.let { id ->
            categoriaLagamRepository.findById(id).orElseGet {
                // Se não encontrar, salva uma nova categoria com o ID e descricao vazia
                categoriaLagamRepository.save(
                    CategoriaLavagemEntity(
                        id = id,
                        descricao = lavagenDTO.descricao // ou defina um valor padrão se quiser
                    )
                )
            }
        }
        val imagemBytes = file.bytes


        val lavagem = LavagemEntity(
            id = null,
            descricao = lavagenDTO.descricao,
            code = lavagenDTO.code,
            imagem = imagemBytes,
            categoria = categoria
        )

        return lavagemService.salvarLavagen(lavagem)
    }

}