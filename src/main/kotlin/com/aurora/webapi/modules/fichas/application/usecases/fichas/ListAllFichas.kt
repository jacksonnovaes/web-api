package com.aurora.webapi.modules.fichas.application.usecases.fichas

import com.aurora.webapi.modules.fichas.FichaReponseDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.ColecaoRepository
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.ComposicaoRepository
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.FichaRepository
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.FornecedorRepository
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.artigo.ArtigoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ListAllFichas(
    private val fichaRepository: FichaRepository,
    private val colecaoRepository: ColecaoRepository,
    private val composicaoRepository: ComposicaoRepository,
    private val artigoRepository: ArtigoRepository,
    private val fornecedorRepository: FornecedorRepository
){
    fun execute(page: Int, linesPerPge: Int, orderBy: String, direction: String): Page<FichaReponseDTO> {
        val pageRequest = PageRequest.of(page, linesPerPge, Sort.Direction.valueOf(direction), orderBy);
        val fichasPage = fichaRepository.findAllFichas(StatusEnum.ACTIVE.name, pageRequest)
        val colecaoIds = fichasPage.mapNotNull { it.colecao }.toSet()
        val composicaoIds = fichasPage.mapNotNull { it.composicao }.toSet()
        val fornecedorIds = fichasPage.mapNotNull { it.fornecedor }.toSet()
        val artigoIds = fichasPage.mapNotNull { it.artigo }.toSet()


        val colecoes = colecaoRepository.findAllById(colecaoIds).associateBy { it.id }
        val composicoes = composicaoRepository.findAllById(composicaoIds).associateBy { it.id }
        val fornecedores = fornecedorRepository.findAllById(fornecedorIds).associateBy { it.id }
        val artigos = artigoRepository.findAllById(artigoIds).associateBy { it.id }


        return fichasPage.map { ficha ->
            val colecao = colecoes[ficha.colecao]

            FichaReponseDTO(
                id = ficha.id,
                numeroFicha = ficha.numeroFicha,
                notaFiscal = ficha.notaFiscal,
                dataEntrada = ficha.dataEntrada,
                largura = ficha.largura,
                artigoId = ficha.artigo,
                status = ficha.status,

                colecao = colecao?.descricao ?: "",
                anoColecao = colecao?.anoCoelecao?.ano ?: "", // pegando do relacionamento da coleção
                composicao = composicoes[ficha.composicao]?.descricao ?: "",
                fornecedor = fornecedores[ficha.fornecedor]?.nome ?: "",

                colecaoId = ficha.colecao,
                anoColecaoId = colecao?.anoCoelecao?.id, // id do ano dentro da coleção
                composicaoId = ficha.composicao,
                fornecedorId = ficha.fornecedor,
                artigo = artigos[ficha.artigo]?.nome
            )
        }
    }
}