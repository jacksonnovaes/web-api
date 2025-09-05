package com.aurora.webapi.modules.fichas.adapters.inbound.controller

import com.aurora.webapi.modules.fichas.adapters.inbound.dto.RoloRequestDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.dto.RoloResponseDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.RoloEntity
import com.aurora.webapi.modules.fichas.application.usecases.rolo.SaveRolo
import com.aurora.webapi.modules.fichas.service.rolo.RoloService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/rolo")
class RoloController(
    private val saveRolo: SaveRolo
) {

    @PostMapping("/id/{id}")
    fun saveRolo(@PathVariable id: Long, rolo: RoloRequestDTO): RoloResponseDTO {
       return saveRolo.execute(rolo)
    }

}