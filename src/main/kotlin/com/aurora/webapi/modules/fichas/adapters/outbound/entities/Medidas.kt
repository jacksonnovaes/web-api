package com.aurora.webapi.modules.fichas.adapters.outbound.entities

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.MedidasEnum
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Embeddable
data class Medidas(

    @Column(name = "valor_medida")
    val valorMedida: Float, // kg ou mts

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_medida")
    val type: MedidasEnum,

    @Column(name = "quantidade")
    val quantidade: Float,

    @Column(name = "rendimento")
    var rendimento: Float

) {

    fun calcularRendimento(valor: Float): Float {
        return if (type == MedidasEnum.KG) {
            valor / rendimento
        } else {
            valor * rendimento
        }
    }


    fun atualizarRendimento(valor: Float) {
        rendimento = calcularRendimento(valor)
    }
}
