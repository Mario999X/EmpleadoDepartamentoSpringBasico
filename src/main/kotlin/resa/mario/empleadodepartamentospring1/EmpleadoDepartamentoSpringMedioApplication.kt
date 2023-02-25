package resa.mario.empleadodepartamentospring1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
@EnableCaching
@EnableR2dbcRepositories
class EmpleadoDepartamentoSpringMedioApplication

fun main(args: Array<String>) {
    runApplication<EmpleadoDepartamentoSpringMedioApplication>(*args)
}
