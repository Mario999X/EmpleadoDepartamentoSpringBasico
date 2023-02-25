package resa.mario.empleadodepartamentospring1.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Repository
import resa.mario.empleadodepartamentospring1.models.Departamento

private val log = KotlinLogging.logger {}

@Repository
class DepartamentosCachedRepositoryImpl
@Autowired constructor(
    private val repository: DepartamentosRepository
) : DepartamentosCachedRepository {

    override suspend fun findAll(): Flow<Departamento> = withContext(Dispatchers.IO) {
        log.info { "Obteniendo todos los departamentos" }

        return@withContext repository.findAll()
    }

    @Cacheable("departamentos")
    override suspend fun findById(id: Long): Departamento? = withContext(Dispatchers.IO) {
        log.info { "Obteniendo departamento con id: $id" }

        return@withContext repository.findById(id)
    }

    @CachePut("departamentos")
    override suspend fun save(entity: Departamento): Departamento = withContext(Dispatchers.IO) {
        log.info { "Almacenando departamento: $entity" }

        return@withContext repository.save(entity)
    }

    @CachePut("departamentos")
    override suspend fun update(id: Long, entity: Departamento): Departamento? = withContext(Dispatchers.IO) {
        log.info { "Actualizando departamento con id: $id" }

        var departamentoDB = repository.findById(id)

        if (departamentoDB != null) {
            departamentoDB = repository.save(entity)
        }

        return@withContext departamentoDB
    }

    override suspend fun deleteById(id: Long): Departamento? = withContext(Dispatchers.IO) {
        log.info { "Eliminando departamento con id: $id " }

        val departamentoDB = repository.findById(id)

        if (departamentoDB != null) {
            repository.delete(departamentoDB)
        }

        return@withContext departamentoDB
    }
}