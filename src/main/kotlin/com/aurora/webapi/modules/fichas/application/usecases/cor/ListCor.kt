package com.aurora.webapi.modules.fichas.application.usecases.cor

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CorEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.CorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ListCor(
    private val corRepository: CorRepository
) {

    fun execute(page: Int, linesPerPage: Int, orderBy: String, direction: String): Page<CorEntity> {
        val pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return corRepository.findAll(pageRequest)
    }
}