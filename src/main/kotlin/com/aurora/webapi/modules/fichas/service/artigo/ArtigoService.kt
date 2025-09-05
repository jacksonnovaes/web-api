    package com.aurora.webapi.modules.fichas.service.artigo

    import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ArtigoEntity
    import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
    import com.aurora.webapi.modules.fichas.adapters.outbound.entities.toDomain
    import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.artigo.ArtigoRepository
    import com.aurora.webapi.modules.fichas.domain.Artigo
    import com.aurora.webapi.modules.fichas.domain.toEntity
    import jakarta.transaction.Transactional
    import org.springframework.data.domain.Page
    import org.springframework.data.domain.Pageable
    import org.springframework.stereotype.Service

    @Service

    class ArtigoService (
       private val artigoRepository: ArtigoRepository
    ){
        @Transactional
         fun save(entity: ArtigoEntity): Artigo {
            return artigoRepository.save(entity.toDomain())
        }
        fun buscarPorId(id: Long): Artigo {
             return artigoRepository.findById(id)
                 ?: throw IllegalArgumentException("Artigo com ID $id não encontrado")
        }

         fun buscarTodos(pageable: Pageable): Page<Artigo> {

            return artigoRepository.findAllByStatus(StatusEnum.ACTIVE, pageable)

        }

         fun buscarTodos(): List<Artigo> {
            return artigoRepository.findAll()
        }

         fun buscarPorIds(ids: List<Long>): List<ArtigoEntity> {
            return artigoRepository.findAllById(ids).map {
                it.toEntity()
            }
        }

         fun deletar(id: Long) {
            artigoRepository.deleteById(id)
        }

         fun buscarPorNomeDescricao(
            termo: String,
            status: String,
            pageable: Pageable
        ): Page<ArtigoEntity> {
            return artigoRepository.findAllByNomeAndStatus(pageable, termo, StatusEnum.ACTIVE)
        }


    }