package com.ding.miniminimoney.owe.api;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        "/loan"
)
class LoanRestController(
        private val oweService: OweService
) {

    @PostMapping("/create/{userId}")
    fun createWallet(
            @PathVariable("userId") userId: String
    ): ResponseEntity<WalletResponseBody> {
        val walletCreated = walletService.createAndAssignWallet(userId)
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(walletCreated.toWalletResponseBody())
    }
}
