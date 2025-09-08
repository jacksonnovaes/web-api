package com.aurora.webapi.modules.fichas.application.usecases.categoria

import com.aurora.webapi.modules.fichas.CategoriaDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.CategoriaRepository
import com.aurora.webapi.modules.fichas.converter.CategoriaConverter
import jakarta.validation.Valid
import org.springframework.stereotype.Service

@Service
class SaveCategoria(
    val categoriaRepository: CategoriaRepository
) {
    fun execute(@Valid categoriaDTO: CategoriaDTO): CategoriaDTO {
        val categoria = CategoriaConverter.toEntity(categoriaDTO)
        return CategoriaConverter.toDTO(categoriaRepository.save(categoria))
    }

}