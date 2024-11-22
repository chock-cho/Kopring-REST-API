package com.practice.kopring.domain;

import com.practice.kopring.api.request.CustomerUpdateRequest
import jakarta.persistence.*
import java.time.LocalDate
import java.time.Period

@Entity
class Customer(
    @Column
    var firstName: String,
    @Column
    var lastName: String,
    @Column
    @Enumerated(EnumType.STRING)
    var gender: Gender,
    @Column
    var birthDate: LocalDate,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id")
    var address : Address? = null

    @Embedded
    var additionalInfo: AdditionalInfo? = null

    val age: Int
        get() = Period.between(birthDate, LocalDate.now()).years

    val fullName: String
        get() = "$firstName $lastName"

    fun update(req: CustomerUpdateRequest) {
        firstName = req.firstName
        lastName = req.lastName
        gender = req.gender
        birthDate = req.birthDate
    }
}
