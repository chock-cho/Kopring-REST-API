package com.practice.kopring.domain

import jakarta.persistence.Embeddable

@Embeddable
class AdditionalInfo (
    var mbti: String?,
    var nickname: String?,
    var interestDomain: String?
)