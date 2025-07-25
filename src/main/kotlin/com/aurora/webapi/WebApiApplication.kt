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
import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.converter.FichaConverter
import com.aurora.webapi.modules.fichas.converter.FornecedorConverter
import com.aurora.webapi.modules.fichas.infra.repositories.FichaRepository
import com.aurora.webapi.modules.fichas.infra.repositories.FornecedorRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDate

@SpringBootApplication
class WebApiApplication(
	private final val colecaoRepository: ColecaoRepository,
	private final val composicaoRepository: ComposicaoRepository,
	private final val employeeRepository: EmployeeRepository,
	private final val userRepository: UserRepository,
	private final val fichaRepository: FichaRepository,
	private final val passwordEncoder: PasswordEncoder,
	private final val fornecedorRepository: FornecedorRepository
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

		val fornecedor = FornecedorDTO(
			id = null,
			nome = " FERNANDO LTDA",
			fichas = emptyList()
		)


		val composicaoEntity = ComposicaoConverter.toEntity(composocao)

		val colecaoEntity = ColecaoConverter.toEntity(colecaoDTO)
		val fornecedorEntity = FornecedorConverter.toEntity(fornecedor)

		val composicaoSaved = composicaoRepository.save(composicaoEntity)
		val colecaoSaved = colecaoRepository.save(colecaoEntity)
		val fornecedorSaved = fornecedorRepository.save(fornecedorEntity)
		employeeRepository.save(employee)

		val ficha  = FichaDTO(
			id = null,
			numeroFicha = "1232",
			notaFiscal = "2020",
			composicaoId = composicaoSaved.id,
			dataEntrada = LocalDate.now(),
			colecaoId = colecaoSaved.id,
			fornecedorId = fornecedorSaved.id,
			largura = 100.00F
		)
		fichaRepository.save(FichaConverter.toEntity(ficha))

	}
}

fun main(args: Array<String>) {
	runApplication<WebApiApplication>(*args)
}

