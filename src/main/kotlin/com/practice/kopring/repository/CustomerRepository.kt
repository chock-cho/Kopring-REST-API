package com.practice.kopring.repository

import com.practice.kopring.domain.Customer
import com.practice.kopring.domain.Gender
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CustomerRepository : JpaRepository<Customer, Long> {
    fun findByGender(gender: Gender): Customer?

    fun findByFirstName(firstName: String): Optional<Customer>
}