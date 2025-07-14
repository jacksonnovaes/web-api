package com.aurora.webapi.modules.usuarios.infra.persistence

import com.aurora.webapi.modules.usuarios.infra.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository: JpaRepository<Employee, Long> {

}