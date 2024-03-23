package com.ding.miniminimoney.wallet.api

import com.ding.miniminimoney.userprofile.rs.dto.UserRequestBody
import com.ding.miniminimoney.userprofile.rs.dto.UserResponseBody
import com.ding.miniminimoney.wallet.entities.rs.dto.WalletResponseBody
import com.ding.miniminimoney.wallet.entities.rs.dto.toWalletResponseBody
import com.ding.miniminimoney.wallet.services.WalletService
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
        "/wallet"
)
class WalletRestController(
        private val walletService: WalletService
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