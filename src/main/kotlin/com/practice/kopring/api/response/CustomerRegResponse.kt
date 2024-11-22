package com.practice.kopring.api.response

import com.practice.kopring.domain.Gender
import com.practice.kopring.service.dto.CustomerRegDto
import java.time.LocalDate

data class CustomerRegResponse(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val birthDate: LocalDate
){
    companion object {
        fun from(dto: CustomerRegDto): CustomerRegResponse =
            CustomerRegResponse(
                id = dto.id,
                firstName = dto.firstName,
                lastName = dto.lastName,
                gender = dto.gender,
                birthDate = dto.birthDate,
            )
    }
}
