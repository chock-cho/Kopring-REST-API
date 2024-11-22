package com.practice.kopring.service.dto

import com.practice.kopring.domain.Customer
import com.practice.kopring.domain.Gender
import jakarta.persistence.Entity
import java.time.LocalDate

class CustomerRegDto(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val birthDate: LocalDate
) {
    companion object {
        fun from(entity: Customer): CustomerRegDto =
            CustomerRegDto(
                id = entity.id,
                firstName = entity.firstName,
                lastName = entity.lastName,
                gender = entity.gender,
                birthDate = entity.birthDate,
            )
    }
}