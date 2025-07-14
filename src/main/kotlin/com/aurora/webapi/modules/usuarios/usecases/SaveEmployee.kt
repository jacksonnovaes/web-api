package com.aurora.webapi.modules.usuarios.usecases

import com.aurora.webapi.modules.usuarios.EmployeeDTO
import com.aurora.webapi.modules.usuarios.converter.EmployeeConverter
import com.aurora.webapi.modules.usuarios.infra.persistence.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class SaveEmployee(
    val employeeRepository: EmployeeRepository
) {

    fun execute(employeeDTO: EmployeeDTO): EmployeeDTO{
        val employessEntity = EmployeeConverter.toEntity(employeeDTO)
        return EmployeeConverter.toDTO(employeeRepository.save(employessEntity))
    }
}