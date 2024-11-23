package com.practice.kopring.domain

import io.kotest.core.spec.style.ExpectSpec

internal class InitLambdaInitBlockKotest : ExpectSpec (
    {
        expect("test case with init lambda") {

        }
    },
) {
    init {
        expect("test case with init block"){

        }
    }
}