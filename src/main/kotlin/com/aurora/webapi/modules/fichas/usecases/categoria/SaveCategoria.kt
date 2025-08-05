package com.aurora.webapi.modules.fichas.usecases.categoria

import com.aurora.webapi.modules.fichas.CategoriaDTO
import com.aurora.webapi.modules.fichas.converter.CategoriaConverter
import com.aurora.webapi.modules.fichas.service.categoria.CategoriaService
import jakarta.validation.Valid
import org.springframework.stereotype.Service

@Service
class SaveCategoria(
    val categoriaService: CategoriaService
) {
    fun execute(@Valid categoriaDTO: CategoriaDTO): CategoriaDTO {
        val categoria = CategoriaConverter.toEntity(categoriaDTO)
        return CategoriaConverter.toDTO(categoriaService.save(categoria))
    }

}