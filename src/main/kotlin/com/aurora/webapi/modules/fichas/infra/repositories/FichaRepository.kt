package com.aurora.webapi.modules.fichas.infra.repositories

import com.aurora.webapi.modules.fichas.infra.entity.FichaEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface FichaRepository: JpaRepository<FichaEntity, Long>{
    @Query(nativeQuery = true,

        value = """SELECT
                         ficha.ID as id_ficha,
                         ficha.ID_artigo,
                         ficha.ID_colecao,
                         ficha.ID_composicao,
                         ficha.id_fornecedor,
                         ficha.largura,
                         ficha.dt_entrada,
                         ficha.dt_registro,
                         ficha.nr_ficha, 
                         ficha.nota_fiscal,
                         ficha.status,
                         fornecedor.nome,categoria.nome, 
                         colecao.descricao,
                         anocolecao.ano_colecao,
                         composicao.descricao
                        FROM TB_FICHA ficha INNER JOIN TB_ARTIGO artigo ON artigo.ID = ficha.ID_ARTIGO
                        INNER JOIN TB_CATEGORIA categoria ON categoria.ID = artigo.ID_CATEGORIA
                        INNER JOIN TB_COLECAO colecao ON colecao.ID = ficha.ID_COLECAO
			            INNER JOIN TB_ANO_COLECAO anocolecao on anocolecao.ID = colecao.ID_ANO_COLECAO
                        INNER JOIN TB_COMPOSICAO  composicao ON composicao.ID_COMPOSICAO = ficha.ID_COMPOSICAO
                        INNER JOIN TB_FORNECEDOR  fornecedor ON fornecedor.ID = ficha.ID_FORNECEDOR
                        WHERE ficha.status = :status
                        """
    )
    fun findAllFichas(@Param("status") status: String,pageable: Pageable): Page<FichaEntity>

    @Query(nativeQuery = true,
        value = """SELECT
                         ficha.ID as id_ficha,
                         ficha.ID_artigo,
                         ficha.ID_colecao,
                         ficha.ID_composicao,
                         ficha.id_fornecedor,
                         ficha.largura,
                         ficha.dt_entrada,
                         ficha.dt_registro,
                         ficha.nr_ficha, 
                         ficha.nota_fiscal,
                         ficha.status,
                         fornecedor.nome,categoria.nome, 
                         colecao.descricao,
                         anocolecao.ano_colecao,
                         composicao.descricao
                        FROM TB_FICHA ficha INNER JOIN TB_ARTIGO artigo ON artigo.ID = ficha.ID_ARTIGO
                        INNER JOIN TB_CATEGORIA categoria ON categoria.ID = artigo.ID_CATEGORIA
                        INNER JOIN TB_COLECAO colecao ON colecao.ID = ficha.ID_COLECAO
			            INNER JOIN TB_ANO_COLECAO anocolecao on anocolecao.ID = colecao.ID_ANO_COLECAO
                        INNER JOIN TB_COMPOSICAO  composicao ON composicao.ID_COMPOSICAO = ficha.ID_COMPOSICAO
                        INNER JOIN TB_FORNECEDOR  fornecedor ON fornecedor.ID = ficha.ID_FORNECEDOR
                        WHERE artigo.nome ILIKE %:artigo% and  ficha.status = :status
                        """
    )
     fun findByNameArtigo( @Param("artigo") artigo: String,
                           @Param("status") status: String, pageable: Pageable): Page<FichaEntity>
}