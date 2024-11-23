package com.practice.kopring.config

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.extensions.spring.SpringExtension
import io.kotest.extensions.spring.SpringTestExtension

class KotestSpringExtension : AbstractProjectConfig() {
    override fun extensions() : List<SpringTestExtension> = listOf(SpringExtension)
}