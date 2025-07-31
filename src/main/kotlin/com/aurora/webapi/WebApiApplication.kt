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
import com.aurora.webapi.modules.fichas.infra.entity.ArtigoEntity
import com.aurora.webapi.modules.fichas.infra.entity.CategoriaEntity
import com.aurora.webapi.modules.fichas.infra.entity.LavagenEntity
import com.aurora.webapi.modules.fichas.infra.repositories.ArtigoRepository
import com.aurora.webapi.modules.fichas.infra.repositories.CategoriaRepository
import com.aurora.webapi.modules.fichas.infra.repositories.FichaRepository
import com.aurora.webapi.modules.fichas.infra.repositories.FornecedorRepository
import com.aurora.webapi.modules.fichas.infra.repositories.LavagemRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Arrays
import java.util.Locale

@SpringBootApplication
class WebApiApplication(
	private final val colecaoRepository: ColecaoRepository,
	private final val composicaoRepository: ComposicaoRepository,
	private final val employeeRepository: EmployeeRepository,
	private final val userRepository: UserRepository,
	private final val fichaRepository: FichaRepository,
	private final val passwordEncoder: PasswordEncoder,
	private final val fornecedorRepository: FornecedorRepository,
	private final val lavagemRepository: LavagemRepository,
	private final val artigoRepository: ArtigoRepository,
	private final val categoriaRepository: CategoriaRepository
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

		val instricoes = LavagenEntity(
			id = null,
			descricao = "nao passar",
			code  = 1,
			imagem = ByteArray(0)
		)


		val categoria = CategoriaEntity(
			nome = "CHIFON"
		)
		val categoriaSaved =  categoriaRepository.save(categoria)
		val instricoes2 = LavagenEntity(
			id = null,
			descricao = "nao lavar",
			code  = 1,
			imagem = ByteArray(0)
		)
		val instricoesSalvas = lavagemRepository.saveAll(listOf(instricoes, instricoes2))

		val artigo = ArtigoEntity(
			id = null,
			nome = "Alfaiataria RVERTON",
			instrucions = instricoesSalvas,
			categotia = categoriaSaved
		)
		val composocao = ComposicaoDTO(
			id = null,
			descricao = "100 % algodao "
		)
		val composocao2 = ComposicaoDTO(
			id = null,
			descricao = "10 % algodao 90% elastano "
		)


		val colecaoDTO = ColecaoDTO(
			id = null,
			nome = "verao",
			ano = 2026,
		)

		val colecaoDTO2 = ColecaoDTO(
			id = null,
			nome = "inverno",
			ano = 2026,
		)

		val fornecedor = FornecedorDTO(
			id = null,
			nome = " FERNANDO LTDA",
			fichas = emptyList()
		)


		val composicaoEntity = ComposicaoConverter.toEntity(composocao)

		val colecaoEntity = ColecaoConverter.toEntity(colecaoDTO)
		val colecaoEntity2 = ColecaoConverter.toEntity(colecaoDTO2)
		val fornecedorEntity = FornecedorConverter.toEntity(fornecedor)

		val composicaoSaved = composicaoRepository.save(composicaoEntity)
		val colecaoSaved = colecaoRepository.save(colecaoEntity)
		val fornecedorSaved = fornecedorRepository.save(fornecedorEntity)
		employeeRepository.save(employee)
		val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
		val dataEntrada = LocalDate.parse("06/04/2025", formatter)
		val artigoSaved = artigoRepository.save(artigo)

		val ficha  = FichaDTO(
			id = null,
			numeroFicha = 1232,
			notaFiscal = 2020,
			composicaoId = composicaoSaved.id,
			dataEntrada = LocalDate.now().minusDays(2),
			artigoId = artigoSaved.id,
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

