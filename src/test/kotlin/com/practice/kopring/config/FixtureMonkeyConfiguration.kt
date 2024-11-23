package com.practice.kopring.config

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.api.generator.DefaultNullInjectGenerator
import com.navercorp.fixturemonkey.jackson.plugin.JacksonPlugin
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
class FixtureMonkeyConfiguration {
    companion object {
        private const val MIN_SIZE = 3
        private const val MAX_SIZE = 3

        val sut: FixtureMonkey =
            FixtureMonkey.builder()
                .plugin(KotlinPlugin())
                .plugin(
                    JacksonPlugin(
                        jacksonObjectMapper()
                            .registerModule(JavaTimeModule()),
                    ),
                )
                .defaultNullInjectGenerator { DefaultNullInjectGenerator.NOT_NULL_INJECT }
                .build()
    }
}