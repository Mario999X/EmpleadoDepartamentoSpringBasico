package resa.mario.empleadodepartamentospring1.services

import kotlinx.coroutines.flow.Flow
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import resa.mario.empleadodepartamentospring1.models.Departamento
import resa.mario.empleadodepartamentospring1.repositories.DepartamentosCachedRepositoryImpl

@Service
class DepartamentosServiceImpl
@Autowired constructor(
    private val repository: DepartamentosCachedRepositoryImpl
) : DepartamentosService {

    override suspend fun findAll(): Flow<Departamento> {
        return repository.findAll()
    }

    override suspend fun findById(id: Long): Departamento? {
        return repository.findById(id)
    }

    override suspend fun save(entity: Departamento): Departamento {
        return repository.save(entity)
    }

    override suspend fun update(id: Long, entity: Departamento): Departamento? {
        return repository.update(id, entity)
    }

    override suspend fun deleteById(id: Long): Departamento? {
        return repository.deleteById(id)
    }
}