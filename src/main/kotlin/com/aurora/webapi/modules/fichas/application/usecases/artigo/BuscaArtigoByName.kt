package com.aurora.webapi.modules.fichas.application.usecases.artigo

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ArtigoEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.artigo.ArtigoRepository
import com.aurora.webapi.modules.fichas.domain.Artigo
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class BuscaArtigoByName(
    val artigoRepository: ArtigoRepository

) {

    @Transactional
    fun execute(nome: String,page: Int, linesPerPage: Int, orderBy: String, direction: String): Page<Artigo>{

        val pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return artigoRepository.findAllByStatus(StatusEnum.ACTIVE,pageRequest)
    }
}