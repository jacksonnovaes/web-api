package com.aurora.webapi.modules.usuarios.services

import com.aurora.webapi.modules.usuarios.EmployeeDTO
import com.aurora.webapi.modules.usuarios.converter.EmployeeConverter
import com.aurora.webapi.modules.usuarios.infra.persistence.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService (
    val employeeRepository: EmployeeRepository
){

    fun saveEmployee(employeeDTO: EmployeeDTO){
        val employee = EmployeeConverter.toEntity(employeeDTO)
        employeeRepository.save(employee)
    }
}