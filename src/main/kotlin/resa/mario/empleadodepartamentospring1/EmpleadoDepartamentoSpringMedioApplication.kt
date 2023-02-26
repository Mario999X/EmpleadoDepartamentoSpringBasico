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
/* -- EXPLICACION
Enlace al generador de proyectos Spring: https://start.spring.io/

Las dependencias que marque en un comienzo:
    - Base de datos [H2]
    - Cache [Spring Cache Abstraction]
    - R2DBC [Spring Data R2DBC]
    - Validation
    - WebSocket

Dependencias que escribi a mano:
    - Kotlin Serialization
        kotlin("plugin.serialization") version "1.7.20"
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    - Comentar la dependencia no reactiva de H2
    - Logs
        implementation("io.github.microutils:kotlin-logging-jvm:3.0.4")

Guia de creacion:

1. Configurar Build

2. Configurar .properties

3. Modelos -> Revisar anotaciones de Spring Usadas

4. Schema.sql -> Cuidado con la sintaxis y con los nombres de tablas/columnas respecto a los modelos

5. Agregar anotaciones a la clase Main de ejecucion [Esta misma clase]
    @EnableCaching
    @EnableR2dbcRepositories

6. Configuracion de la clase LoadSchema

7. Interfaz repositorio de los modelos [Marcadas con @Repository]

8. Interfaz repositorioCached de los modelos [No marcada, se escriben las funciones que vayamos a necesitar]

9. Clase de repositorioImpl -> donde se inyecte [@Autowired] por constructor el repositorio normal, se implementa
    el repositorio cacheado, esta clase tendra una anotacion de [@Repository]

10. Se generan los servicios relacionados con las entidades
    - Se genera una interfaz service con los mismos metodos que en el repositorioCached
    - Se le inyecta los repositorios que hagan falta [aqui es donde podremos limitar las operaciones marcadas por
    las relaciones de las entidades]
    - Aqui podremos jugar con las expeciones que mandaremos luego al controlador

11. Configuracion de la clase APIConfig

12. Controladores
    - Seran marcadas con dos anotaciones [@RestController y @RequestMapping()], se le inyectaran los servicios usados.
    - Cada metodo usara una anotacion de Spring
    - Aunque en este proyecto no sera aplicado, los metodos de esta clase deberan estar en publico.

13. La configuracion de la cache de Spring aplicada es sencilla:
    - Se basa en anotaciones aplicadas en el repositorioImpl
    - Principalmente se aplicaran 3:
        - Cacheable("")
        - CachePut("")
        - CacheEvict("")
 */