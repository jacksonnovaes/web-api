package com.aurora.webapi.modules.fichas.application.usecases.rolo

import com.aurora.webapi.modules.fichas.CorDTO
import com.aurora.webapi.modules.fichas.adapters.inbound.dto.RoloRequestDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.dto.CorResponseDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.dto.RoloResponseDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CorEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.Medidas
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.RoloEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.MedidasEnum
import com.aurora.webapi.modules.fichas.service.rolo.RoloService
import org.springframework.stereotype.Service

@Service
class SaveRolo(
    private val roloService: RoloService
) {

    fun execute(roloRequestDTO: RoloRequestDTO): RoloResponseDTO {
        val roloEntity = RoloEntity(
            id = null,
            codigo = roloRequestDTO.codigo,
            localizacao = roloRequestDTO.localizacao,
            medidas = Medidas(
                valorMedida = roloRequestDTO.valorMedida,
                type = MedidasEnum.fromValue(roloRequestDTO.typeMedida),
                quantidade = roloRequestDTO.quantidade,
                rendimento = roloRequestDTO.rendimento
            ),
            fichaId = roloRequestDTO.fichaId,
            status = roloRequestDTO.status,
            cor = CorEntity(id = roloRequestDTO.corId, "","")
        )
      val roloResponse = roloService.save(roloEntity)
        return RoloResponseDTO(
            id = roloResponse.id,
            codigo =roloResponse.codigo,
            localizacao = roloResponse.localizacao,
            tipoMedida = roloResponse.medidas.type?.name ?: "",
            cor = roloResponse.cor.nome,
            fichaId = roloResponse.fichaId,
            status = roloResponse.status.name,
        )
    }
}