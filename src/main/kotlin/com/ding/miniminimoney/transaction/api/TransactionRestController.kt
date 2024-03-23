package com.ding.miniminimoney.transaction.api

import com.ding.miniminimoney.transaction.rs.dto.TransactionCreatedResponseBody
import com.ding.miniminimoney.transaction.rs.dto.TransactionRequestBody
import com.ding.miniminimoney.transaction.rs.dto.toTransactionCreatedResponseBody
import com.ding.miniminimoney.transaction.services.TransactionService
import com.ding.miniminimoney.wallet.entities.rs.dto.toWalletResponseBody
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
        "/transaction"
)
class TransactionRestController(
        private val transactionService: TransactionService
) {
    @PostMapping("/createTransaction/{userId}")
    fun createTransaction(

        @PathVariable("userId") userId: String,

        @RequestBody
        createTransactionRequestBody: TransactionRequestBody

    ): ResponseEntity<TransactionCreatedResponseBody> {

            val transactionCreated = transactionService.createTransaction(userId, createTransactionRequestBody)
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .allow(HttpMethod.GET)
                    .body(transactionCreated.toTransactionCreatedResponseBody())
        }

}