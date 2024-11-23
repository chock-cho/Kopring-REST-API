package com.infcon.kopring.config

import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
open class WithTestContainersJunit5 {
    companion object {
        @JvmStatic
        @Container
        @ServiceConnection
        var db: GenericContainer<*> = GenericContainer("oscarfonts/h2:latest").apply {
            withExposedPorts(9092) // H2의 기본 포트
            withEnv("H2_OPTIONS", "-tcp -tcpAllowOthers")
        }
    }
}
