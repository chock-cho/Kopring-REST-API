package com.practice.kopring.service

import com.practice.kopring.domain.Customer
import com.practice.kopring.domain.Gender
import com.practice.kopring.repository.CustomerRepository
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.springframework.data.repository.findByIdOrNull
import java.time.LocalDate
import kotlin.test.assertEquals

internal class CustomerServiceAnnotationSpecKotest : AnnotationSpec() {
    @MockK
    lateinit var customerRepository: CustomerRepository

    @InjectMockKs
    lateinit var customerService: CustomerService

    @Test
    fun getInfoWithKotestAssertions() {
        every { customerRepository.findByIdOrNull(any()) } returns
                Customer(
                    firstName = "Sujung",
                    lastName = "Shin",
                    gender = Gender.FEMALE,
                    birthDate = LocalDate.now()
                )

        val result = customerService.getInfo(ID)

        result.firstName shouldBe FIRSTNAME
        result.lastName shouldBe LASTNAME
        result.gender shouldBe gender
        result.gender shouldBeIn Gender.entries
        result.gender shouldNotBe Gender.MALE
        result.birthDate shouldBe birthDate
    }

    @Test
    fun getInfoWithTraditionalAssertions() {
        every { customerRepository.findByIdOrNull(any()) } returns
                Customer(
                    firstName = "Sujung",
                    lastName = "Shin",
                    gender = Gender.FEMALE,
                    birthDate = LocalDate.now()
                )

        val result = customerService.getInfo(ID)

        assertEquals(FIRSTNAME, result.firstName)
        assertEquals(LASTNAME, result.lastName)
        assertEquals(gender, result.gender)
        assertEquals(birthDate, result.birthDate)
    }

    companion object {
        private const val ID = 1L
        private const val FIRSTNAME = "Sujung"
        private const val LASTNAME = "Shin"
        private val gender = Gender.FEMALE
        private val birthDate = LocalDate.now()
    }
}