package com.practice.kopring.util;

import mu.KLogger
import mu.KotlinLogging

class Logger {
    companion object {
        inline val <reified T> T.log: KLogger
            get() = KotlinLogging.logger(T::class.java.name)
    }
}
