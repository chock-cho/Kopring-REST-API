package com.practice.kopring.api.controller

import com.navercorp.fixturemonkey.kotlin.giveMeOne
import com.ninjasquad.springmockk.MockkBean
import com.practice.kopring.config.FixtureMonkeyConfiguration.Companion.sut
import com.practice.kopring.service.CustomerService
import com.practice.kopring.service.dto.CustomerDto
import io.kotest.core.spec.style.ExpectSpec
import io.mockk.every
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
internal class CustomerControllerExpectSpecSpringBootTest :ExpectSpec() {
    @MockkBean
    private lateinit var customerService: CustomerService

    @Autowired
    private lateinit var mockMvc: MockMvc
    init {
        expect("getInfo") {
            val id = 1L
            val uri = "/customers/$id"
            val customer = sut.giveMeOne<CustomerDto>() // dummy data generate by FixtrueMonkey
            every { customerService.getInfo(any()) } returns customer

            mockMvc.get(uri)
                .andExpect { status { isOk() } }
                .andExpectAll {
                    status { isOk() }
                    MockMvcResultMatchers.jsonPath("$.firstName").value(customer.firstName)
                    MockMvcResultMatchers.jsonPath("$.lastName").value(customer.lastName)
                    MockMvcResultMatchers.jsonPath("$.gender").value(customer.gender)
                    MockMvcResultMatchers.jsonPath("$.birthDate").value(customer.birthDate)
                }
                .andDo { print() }
        }
    }
}