package com.aurora.webapi.modules.fichas.domain


import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CorEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.Medidas
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.RoloEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum

data class Rolo(

    val id: Long? = null,
    val codigo: Long,
    val localizacao: String,
    val medidas: Medidas,
    val cor: CorEntity,
    val fichaId: Long,
    val status: StatusEnum


)
fun toEntity(rolo: Rolo): RoloEntity {
    return RoloEntity(
        rolo.id,
        rolo.codigo,
        rolo.localizacao,
        Medidas(
            rolo.medidas.valorMedida,
            rolo.medidas.type,
            rolo.medidas.quantidade,
            rolo.medidas.rendimento
        ),
        cor = rolo.cor,
        fichaId = rolo.fichaId,
        status = rolo.status
    )
}
