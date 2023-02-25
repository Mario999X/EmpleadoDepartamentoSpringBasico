import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.3"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	kotlin("plugin.serialization") version "1.7.20"
}

group = "resa"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	// Spring Boot y Spring Data Reactive
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	// Validaciones de Spring Boot
	implementation("org.springframework.boot:spring-boot-starter-validation")
	// Webflux y Reactividad
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	// WebSocket
	implementation("org.springframework.boot:spring-boot-starter-websocket")
	// Jackson JSON
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	// Cache Spring
	implementation("org.springframework.boot:spring-boot-starter-cache")
	// Serializable Json Kotlin
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
	// Kotlin
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	// Base de datos
	//runtimeOnly("com.h2database:h2")
	runtimeOnly("io.r2dbc:r2dbc-h2")
	// Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	// Loggging
	implementation("io.github.microutils:kotlin-logging-jvm:3.0.4")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
