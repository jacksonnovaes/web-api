package com.aurora.webapi.modules.fichas.usecases.artigo

import com.aurora.webapi.modules.fichas.infra.entity.ArtigoEntity
import com.aurora.webapi.modules.fichas.service.artigo.ArtigoService
import org.springframework.stereotype.Service

@Service
class ListArtigos(
     val artigoService: ArtigoService
) {

     fun execute():List<ArtigoEntity>{
        return artigoService.buscarTodos()
    }
}