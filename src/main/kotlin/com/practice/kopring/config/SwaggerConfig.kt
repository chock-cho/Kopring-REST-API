package com.practice.kopring.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.servers.Server
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@OpenAPIDefinition(servers = [Server(url = "/", description = "Default Server URL")])
@Configuration
class SwaggerConfig{
    private fun authComponent(): Components {
        return Components().addSecuritySchemes(
            "session-token",
            SecurityScheme()
                .type(SecurityScheme.Type.APIKEY)
                .`in`(SecurityScheme.In.HEADER)
                .name("Authorization")
        )
    }

    @Bean
    fun KopringPracticeAPI(): OpenAPI {
        val info = io.swagger.v3.oas.models.info.Info()
            .title("Kopring-Practice API")
            .description(
                """
                        ### Korping REST API 명세 문서입니다.                    
                        """.trimIndent()
            )
            .version("v0.1")
        return OpenAPI()
            .info(info)
            .components(authComponent())
    }
}