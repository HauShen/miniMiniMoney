package com.ding.miniminimoney.transaction.entities.api;


import com.ding.miniminimoney.owe.rs.dto.LoanRequestBody
import com.ding.miniminimoney.owe.rs.dto.LoanResponseBody
import com.ding.miniminimoney.owe.services.LoanService
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
        "/loan"
)
class LoanRestController(
        private val loanService: LoanService
) {

    @PostMapping("/createLoan/{userId}")
    fun createLoan(
        @PathVariable("userId") userId: String,

        @RequestBody
        createLoanRequestBody: LoanRequestBody

    ): ResponseEntity<LoanResponseBody> {
        val loanCreated = loanService.createLoan(userId, createLoanRequestBody)
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .allow(HttpMethod.GET)
                .body(loanCreated)
    }
}
