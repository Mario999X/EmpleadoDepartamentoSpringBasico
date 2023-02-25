package resa.mario.empleadodepartamentospring1.controller

import kotlinx.coroutines.flow.toList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import resa.mario.empleadodepartamentospring1.config.APIConfig
import resa.mario.empleadodepartamentospring1.models.Departamento
import resa.mario.empleadodepartamentospring1.services.DepartamentosServiceImpl

@RestController
@RequestMapping(APIConfig.API_PATH + "/departamentos")
class DepartamentoController
@Autowired constructor(
    private val service: DepartamentosServiceImpl
) {
    @GetMapping("")
    suspend fun findAll(): ResponseEntity<List<Departamento>> {
        return ResponseEntity.ok(service.findAll().toList())
    }
}