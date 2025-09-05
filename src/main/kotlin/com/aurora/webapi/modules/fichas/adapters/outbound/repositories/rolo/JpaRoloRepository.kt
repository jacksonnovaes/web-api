package com.aurora.webapi.modules.fichas.adapters.outbound.repositories.rolo

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.RoloEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaRoloRepository: JpaRepository<RoloEntity, Long> {
}