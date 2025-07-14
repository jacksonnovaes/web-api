package com.aurora.webapi.modules.usuarios.converter

import com.aurora.webapi.modules.usuarios.EmployeeDTO
import com.aurora.webapi.modules.usuarios.infra.entity.Employee
import com.aurora.webapi.modules.usuarios.infra.entity.User
import org.springframework.modulith.aptk.tools.TypeUtils


object EmployeeConverter {


        fun toEntity(employee: EmployeeDTO): Employee {

            return Employee(
                employee.id,
                employee.nome,
                employee.lastName,
                employee.documentId,
                    null

            )
        }

    fun toDTO(employee: Employee): EmployeeDTO {

        return EmployeeDTO(
            employee.id,
            employee.nome,
            employee.lastName,
            employee.documentId
        )
    }

}