package com.practice.kopring.api.controller

import com.practice.kopring.api.request.CustomerRegRequest
import com.practice.kopring.api.request.CustomerUpdateRequest
import com.practice.kopring.api.response.CustomerRegResponse
import com.practice.kopring.api.response.CustomerResponse
import com.practice.kopring.service.CustomerService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CostumerController (
    private val customerService: CustomerService,
){
    @Tag(name = "Customer API")
    @Operation(summary = "사용자 정보 조회", description = "사용자 id로 사용자 정보를 조회합니다.")
    @GetMapping("/customers/{id}")
    fun getInfo(
        @PathVariable id: Long,
    ): ResponseEntity<CustomerResponse> = ResponseEntity.ok().body(CustomerResponse.from(customerService.getInfo(id)))

    @Tag(name = "Customer API")
    @Operation(summary = "사용자 등록", description = "사용자 정보를 입력하여 새 사용자 회원가입을 진행합니다.")
    @PostMapping("/customers")
    fun register(
        @RequestBody req: CustomerRegRequest,
    ): ResponseEntity<CustomerRegResponse> {
        val registeredInfo = customerService.register(req)

        return ResponseEntity.ok().body(CustomerRegResponse.from(registeredInfo))
    }

    @Tag(name = "Customer API")
    @Operation(summary = "사용자 정보 수정", description = "기존 사용자 정보를 수정합니다.")
    @PutMapping("/customers/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody req: CustomerUpdateRequest,
    ): ResponseEntity<CustomerResponse> =
        with(customerService.update(id, req)){
            return ResponseEntity.ok().body(CustomerResponse.from(this))
        }
}