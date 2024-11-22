package com.practice.kopring.api.request

import com.practice.kopring.domain.Gender
import java.time.LocalDate

data class CustomerRegRequest(
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val birthDate: LocalDate,
    )
