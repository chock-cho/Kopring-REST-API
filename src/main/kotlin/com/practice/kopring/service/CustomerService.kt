package com.practice.kopring.service

import com.practice.kopring.api.request.CustomerRegRequest
import com.practice.kopring.api.request.CustomerUpdateRequest
import com.practice.kopring.domain.Customer
import com.practice.kopring.repository.CustomerRepository
import com.practice.kopring.service.dto.CustomerDto
import com.practice.kopring.service.dto.CustomerRegDto
import com.practice.kopring.util.Logger.Companion.log
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
) {
    fun register(req: CustomerRegRequest) : CustomerRegDto {
        val customer =
            Customer(
                firstName = req.firstName,
                lastName = req.lastName,
                gender = req.gender,
                birthDate = req.birthDate,
            )

        return CustomerRegDto.from(customerRepository.save(customer))
            .also{ log.info{ "New Customer Registeration successfully completed, id: ${customer.id} "} }
    }

    fun getInfo(id: Long): CustomerDto {
        val customer = customerRepository.findByIdOrNull(id) ?: throw RuntimeException()

        return CustomerDto.from(customer)
    }

    @Transactional
    fun update(
        id: Long,
        req: CustomerUpdateRequest,
    ): CustomerDto {
        val customer = customerRepository.findByIdOrNull(id) ?: throw RuntimeException()
        customer.update(req)

        return CustomerDto.from(customer)
    }
}