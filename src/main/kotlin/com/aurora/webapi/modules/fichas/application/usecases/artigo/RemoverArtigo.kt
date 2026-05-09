package com.aurora.webapi.modules.fichas.application.usecases.artigo

import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ArtigoEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.toDomain
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.artigo.ArtigoRepository
import org.springframework.stereotype.Service

@Service
class  RemoverArtigo(
    val artigoRepository: ArtigoRepository

) {

    fun execute(id: Long){
        val artigo = artigoRepository.findById(id) ?:
           throw EntityNotFoundException("artigo nao encontrado")

        val artigoDTO = ArtigoEntity(
            id = artigo.id,
            nome = artigo.nome,
            instrucions = artigo.instrucionsIds?.map { it },
            categoria = artigo.categoriaId,
            status = StatusEnum.INACTIVE
        )
        artigoRepository.save(artigoDTO.toDomain())
    }

}