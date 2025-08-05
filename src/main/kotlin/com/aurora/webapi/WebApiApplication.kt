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
import com.aurora.webapi.modules.fichas.infra.entity.AnoColecaoEntity
import com.aurora.webapi.modules.fichas.infra.entity.ArtigoEntity
import com.aurora.webapi.modules.fichas.infra.entity.CategoriaEntity
import com.aurora.webapi.modules.fichas.infra.entity.CategoriaLavagemEntity
import com.aurora.webapi.modules.fichas.infra.entity.ColecaoEntity
import com.aurora.webapi.modules.fichas.infra.entity.LavagenEntity
import com.aurora.webapi.modules.fichas.infra.repositories.AnoColecaoRepository
import com.aurora.webapi.modules.fichas.infra.repositories.ArtigoRepository
import com.aurora.webapi.modules.fichas.infra.repositories.CategoriaLagamRepository
import com.aurora.webapi.modules.fichas.infra.repositories.CategoriaRepository
import com.aurora.webapi.modules.fichas.infra.repositories.FichaRepository
import com.aurora.webapi.modules.fichas.infra.repositories.FornecedorRepository
import com.aurora.webapi.modules.fichas.infra.repositories.LavagemRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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
	private final val categoriaRepository: CategoriaRepository,
	private final val categoriaLagamRepository: CategoriaLagamRepository,
	private final val anoColecaoRepository: AnoColecaoRepository
) : CommandLineRunner {

	override fun run(vararg args: String?) {

		val user = User(
			login = "jackson.novaes@live.com",
			pass = passwordEncoder.encode("11223344")
		)
		val userSaved  = userRepository.save(user)

		val ano2027 = AnoColecaoEntity(
			null,
			ano = 2027.toString()
		)
		val ano2026 = AnoColecaoEntity(
			null,
			ano = 2025.toString()
		)

		val anoColecao2025 = anoColecaoRepository.save(ano2027)
		val anoColecao2026 = anoColecaoRepository.save(ano2026)

		val categoriaLavagem = CategoriaLavagemEntity(
			id = null,
			descricao = "lavagens",

		)

		val categoriaLavagemSaved = categoriaLagamRepository.save(categoriaLavagem)
		val employee = Employee(
			id = null,
			nome = "Jackson",
			lastName = "Bispo de oliveira",
			documentId = "39219796848",
			userId = userSaved.id

		)
		val hexImage = """
  89504e470d0a1a0a0000000d494844520000002a0000002a0806000000c5c3c95b000000017352474200aece1ce90000000467414d410000b18f0bfc6105000000097048597300000b1100000b11017f645f910000001974455874536f6674776172650041646f626520496d616765526561647971c9653c000002a5494441545847ed984b8f0d411886db2d71272e41dc1211096221828d482c2c58f805c40fe01f8825d6125b0921d85ab1c0c6ed0fd8103b3193b8240871bf3c6f57d7f8ba4e4dcda939e774cfa29fe44955f5f4e59baefebabf3a4547c70c6756d57a96e2569c5d8edae11b3ec79fe568124ee2df96fd8a87b14678e796556d9bccc7f5aefb9f70ea4fe125d72d7ee063fc8073b46144fcc2557800fd8d3b81d75d378e02f553701917a1d00946a558894fd15ffb38d6f03bc6d0ddfce2bac59f112adee3b8ebc649059accba21a338928f572a503fed163d4bfb5153154349b007f59a8bb101f7e1927294412ad04d55eb5136dec2077805d7a045e3ab781f6f6218cc0ebc8bfafb596dc82115e8dcaaf528f083b8100fe166b4acc3dda857dc110c676417eec4c5b817c3f3274905aaecb3ac40ffdceaa51ca2c4d057452809c3e3edd8efe7d1b16f5db7243c361968c82bfceeba253d279b82a9f6ff5cb5a227b17202fd88bf5d7724d8583656ed043981e6ec3b287a8e6b3479f11cfc876082b602b55fa5be6832505b00696af59aeb9be906aa0cceba2360137135ea75d737d30d741eea4b95c3cbaa15439dfad47b4f5f9fb5aedb37031539a940c36fb945cf5b6e311d16e959a40255a59422f7cb3410a9407393655092773c3799ecc9c2136becb7c52e6aafa57eb84f58a8d4c8095453bdc0754bc23baeb12f986345f727d44251a8c4d3a2ce925c8a8409a1eafba8eb963f02a850f6281065aed6374ff006eae21e7f475ee01dbc873618153563f80e75de4768518daa3a563c4415e8936257a1b7b5a1414ea3bff6396db0cca464eaa9982ca94097576d536ca9da2861e6d95f4a54715fc4d798b5bec940d32cb6e331d42a559cc733ae1bc73e276d7a016be4bc9e9aa467c9134efd36d4f4abe8d07fd6066ff01a3e2b471d1d1dc3a428fe01d566c4467e3beee70000000049454e44ae426082
""".trim().replace("\n", "").replace(" ", "")
		val instricoes = LavagenEntity(
			id = null,
			descricao = "nao passar",
			code  = 1,
			imagem =  hexToByteArray(hexImage),
			categoria = categoriaLavagemSaved
		)


		val categoria = CategoriaEntity(
			nome = "CHIFON"
		)

		val hexImage2 = """
  89504e470d0a1a0a0000000d494844520000002a0000002a0806000000c5c3c95b000000017352474200aece1ce90000000467414d410000b18f0bfc6105000000097048597300000b1100000b11017f645f910000001974455874536f6674776172650041646f626520496d616765526561647971c9653c00000264494441545847ed964ba84d5118808ff7e37a0e2424252999c82b8f912862a6c8406146c9400674078a890165c2c8c0c4230351ca0051c490880989bc1f4511451edfb7ef3eb773d7d9fb9c7d4ffbb207ebabaf73f6bfd6defbdf6bedf5af5d8b44229148246454fa5b2683701c0e498e5a60c77678917db81a3fe06f2c8b093806bfe101bc811d331e5fe39f01f60a8ec44c8a8ce870dc86b3f197810e71663ea636b20cb7e20f5c880fb0b29c4747757772546136a2895e4b8e2acc0c7c8b9fd057ac89c1e9efffe6055e47abc02a03215549d49277119dfe35e802ee4391555f060e88a3955783ad2673f02ada673e3ec55e8a26ba007dd29938d5403fb1a88fc5bc448d5b437d3f87e1663c8585e9c2c3f81deb85f95f780efbd06a44dddb8fa3c5586ee16d7c87ae502f583616ff9de8f517e14b6c4b379acc4fdc8503f15112e207ca43f4beee866df165fe8c9e70c84006ad2ac6249cd8f337932938bae76f1347d0fb9e4c8e5a6069b88476be89aed646a6e365f4c9971b0870fa9ee03d9c6b206007bec2d3e80886ac45abc0339c66208f2d68928ee85203012662bbee31107010ebeddb0d049c41dbbee03c030126ff08edb3ce401693f131da69bf810c9cf2bde814f90918b204efe31dccda0edd2ecfe2266c2aec2947d11c4e244719588aece0c741de3b54046b615e12455889e6f11c9b0663317e4557f90603e0cdb21c9a9ad56692963d47be9e70a8e7e6b5199f85efd18d603df6d6d1117801dd7dc4697b835eb0083e7d59b890ac182e54133f86d6d6045f5a6f5645fde2efaa8fe80a74347d1a1bfb83d3e3fe9fb5b03aa53187bbe8c28d44229148a432d46a7f0156f6c629e72213810000000049454e44ae426082
""".trim().replace("\n", "").replace(" ", "")
		val categoriaSaved =  categoriaRepository.save(categoria)
		val instricoes2 = LavagenEntity(
			id = null,
			descricao = "nao lavar",
			code  = 1,
			imagem = hexToByteArray(hexImage2),
			categoria = categoriaLavagem
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
			anoColecaoId = anoColecao2025.id,
		)

		val colecaoDTO2 = ColecaoDTO(
			id = null,
			nome = "inverno",
			anoColecaoId = anoColecao2026.id,
		)

		val fornecedor = FornecedorDTO(
			id = null,
			nome = " FERNANDO LTDA",
			fichas = emptyList()
		)
		val colecaoEntity = ColecaoEntity(
			id = null,
			descricao = colecaoDTO.nome,
			anoCoelecao = anoColecao2025
		)


		val composicaoEntity = ComposicaoConverter.toEntity(composocao)


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
			anoColecaoId = colecaoSaved.anoCoelecao?.id,
			fornecedorId = fornecedorSaved.id,
			largura = 100.00F
		)
		fichaRepository.save(FichaConverter.toEntity(ficha))

	}
}

fun hexToByteArray(hex: String): ByteArray {
	return hex.chunked(2)
		.map { it.toInt(16).toByte() }
		.toByteArray()
}



fun main(args: Array<String>) {
	runApplication<WebApiApplication>(*args)
}

