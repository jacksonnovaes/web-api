package com.aurora.webapi.modules.fichas.application.usecases.artigo

import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.ArtigoResponseDTO
import com.aurora.webapi.modules.fichas.CategoriaDTO
import com.aurora.webapi.modules.fichas.LavagenRespondeDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.CategoriaRepository
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.LavagemRepository
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.artigo.ArtigoRepository
import com.aurora.webapi.modules.fichas.domain.Artigo
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ListArtigos(
     val artigoRepository: ArtigoRepository,
     val lavagemRepository: LavagemRepository,
     val categoriaRepository: CategoriaRepository
) {
    @Transactional
    fun execute(
        page: Int,
        linesPerPage: Int,
        orderBy: String,
        direction: String
    ): Page<ArtigoResponseDTO> {

        val pageRequest = PageRequest.of(
            page,
            linesPerPage,
            Sort.Direction.valueOf(direction),
            orderBy
        )

        val artigos = artigoRepository.findAllByStatus(StatusEnum.ACTIVE, pageRequest)

        return artigos.map { artigo ->
            val categoria = categoriaRepository.findById(artigo.categoriaId!!)
                .orElseThrow { EntityNotFoundException("Categoria com id ${artigo.categoriaId} não encontrada") }

            val instrucoes = artigo.instrucionsIds?.map { lavagemId ->
                lavagemRepository.findById(lavagemId)
                    .orElseThrow { EntityNotFoundException("Lavagem com id $lavagemId não encontrada") }
            }

            ArtigoResponseDTO(
                id = artigo.id,
                nome = artigo.nome,
                categoriaDTO = CategoriaDTO(categoria.id,categoria.nome),// ou categoria.nome, dependendo do que seu DTO espera
                instrucoes = instrucoes?.map { LavagenRespondeDTO(
                    it.id,
                    it.descricao,
                    it.code,
                    it.imagem
                ) },
                status = artigo.status?.name
            )
        }
    }


}