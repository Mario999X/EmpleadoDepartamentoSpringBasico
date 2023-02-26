package resa.mario.empleadodepartamentospring1.repositories.departamento

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import resa.mario.empleadodepartamentospring1.models.Departamento

@Repository
interface DepartamentoRepository : CoroutineCrudRepository<Departamento, Long> {
}