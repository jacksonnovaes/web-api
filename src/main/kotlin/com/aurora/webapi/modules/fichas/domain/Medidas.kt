package com.aurora.webapi.modules.fichas.domain

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.MedidasEnum

data class Medidas(

    val valorMedida: Float, // kg ou mts

    val type: MedidasEnum?,

    val quantidade: Float,

    var rendimento: Float
) {

    init {
        rendimento = calcularRendimento()
    }

private fun calcularRendimento(): Float {
    return if (type == MedidasEnum.KG) {
        valorMedida / quantidade
    } else {
        valorMedida * quantidade
    }
}
}
