package com.ding.miniminimoney.owe.api;


import com.ding.miniminimoney.owe.rs.dto.DebtRequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        "/debt"
)
class DebtRestController(
        private val debtService: DebtService
) {

    @PostMapping("/create/{userId}")
    fun createDebt(
            @PathVariable("userId") userId: String,

            @RequestBody
            createDebtRequestBody:DebtRequestBody


    ): ResponseEntity<DebtResponseBody> {
        val walletCreated = walletService.createAndAssignWallet(userId)
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(walletCreated.toWalletResponseBody())
    }
}
