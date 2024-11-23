package com.practice.kopring.domain

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class CustomerJUnitTest {
    @BeforeEach
    fun before(){
        println("${this::class.simpleName} start")
    }

    @AfterEach
    fun after() {
        println("${this::class.simpleName} end")
    }

    @Test
    fun `fullname is the text of firstname lastname combined with a space delimiter` () {
        val customer =
            Customer(
                firstName = "Sujung",
                lastName = "Shin",
                gender = Gender.FEMALE,
                birthDate= LocalDate.now()
            )
        val expectedFullName = "${customer.firstName} ${customer.lastName}"

        assertEquals(expectedFullName, customer.fullName)
    }
}