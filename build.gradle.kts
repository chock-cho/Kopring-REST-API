plugins {
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"

	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	kotlin("kapt") version "1.9.25"
	kotlin("plugin.jpa") version "1.9.25"
}

group = "com.kotlin"
version = "0.0.1-SNAPSHOT"
val kotestVersion = "5.7.2"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-testcontainers:3.1.0")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
	implementation("io.github.microutils:kotlin-logging:2.1.23")
	testImplementation("org.testcontainers:junit-jupiter:1.19.0")
	testImplementation("io.kotest:kotest-runner-junit5:5.6.2")
	testImplementation("io.kotest:kotest-assertions-core:5.6.2")
	testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
	testImplementation("io.kotest.extensions:kotest-extensions-testcontainers:2.0.1")
	testImplementation("io.mockk:mockk:1.13.7")
	testImplementation("com.ninja-squad:springmockk:4.0.2")
	testImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter:1.0.15")
	testImplementation("com.navercorp.fixturemonkey:fixture-monkey-jackson:1.0.15")
	testImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter-kotlin:1.0.15")
	testImplementation("net.jqwik:jqwik:1.6.4")
	testImplementation("net.jqwik:jqwik-kotlin:1.6.4")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}
allOpen {
	annotation("jakarta.persistence")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
