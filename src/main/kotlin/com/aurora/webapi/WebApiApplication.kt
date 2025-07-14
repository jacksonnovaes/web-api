package com.aurora.webapi

import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.ComposicaoDTO
import com.aurora.webapi.modules.fichas.converter.ColecaoConverter
import com.aurora.webapi.modules.fichas.converter.ComposicaoConverter
import com.aurora.webapi.modules.fichas.infra.repositories.ColecaoRepository
import com.aurora.webapi.modules.fichas.infra.repositories.ComposicaoRepository
import com.aurora.webapi.modules.usuarios.infra.entity.Employee
import com.aurora.webapi.modules.usuarios.infra.entity.User
import com.aurora.webapi.modules.usuarios.infra.persistence.EmployeeRepository
import com.aurora.webapi.modules.auth.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
class WebApiApplication(
	private final val colecaoRepository: ColecaoRepository,
	private final val composicaoRepository: ComposicaoRepository,
	private final val employeeRepository: EmployeeRepository,
	private final val userRepository: UserRepository,
	private final val passwordEncoder: PasswordEncoder
) : CommandLineRunner {

	override fun run(vararg args: String?) {

		val user = User(
			login = "jackson.novaes@live.com",
			pass = passwordEncoder.encode("11223344")
		)
		val userSaved  = userRepository.save(user)
		val employee = Employee(
			id = null,
			nome = "Jackson",
			lastName = "Bispo de oliveira",
			documentId = "39219796848",
			userId = userSaved.id

		)
		val composocao = ComposicaoDTO(
			id = null,
			descricao = "100 % algodao",
			cor = "#fff"
		)

		val colecaoDTO = ColecaoDTO(
			id = null,
			nome = "verao",
			ano = 2026,
		)
		val composicaoEntity = ComposicaoConverter.toEntity(composocao)
		val colecaoEntity = ColecaoConverter.toEntity(colecaoDTO)
		composicaoRepository.save(composicaoEntity)
		colecaoRepository.save(colecaoEntity)

		employeeRepository.save(employee)

	}
}

fun main(args: Array<String>) {
	runApplication<WebApiApplication>(*args)
}

