package resa.mario.empleadodepartamentospring1.services.departamento

import kotlinx.coroutines.flow.Flow
import resa.mario.empleadodepartamentospring1.models.Departamento

interface DepartamentosService {
    suspend fun findAll(): Flow<Departamento>
    suspend fun findById(id: Long): Departamento?
    suspend fun save(entity: Departamento): Departamento
    suspend fun update(id: Long, entity: Departamento): Departamento?
    suspend fun deleteById(id: Long): Departamento?
}