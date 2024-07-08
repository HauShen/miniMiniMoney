package com.ding.miniminimoney.transaction.entities.api;

import com.ding.miniminimoney.owe.rs.dto.DebtRequestBody;
import com.ding.miniminimoney.owe.rs.dto.DebtResponseBody;
import com.ding.miniminimoney.owe.services.DebtService;
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping(
        "/debt"
)
class DebtRestController(
    private val debtService: DebtService
) {

    @PostMapping("/createDebt/{userId}")
    fun createDebt(
        @PathVariable("userId") userId: String,

        @RequestBody
        createDebtRequestBody:DebtRequestBody

    ):ResponseEntity<DebtResponseBody>

    {
        val debtCreated = debtService.createDebt(userId, createDebtRequestBody)
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(debtCreated)
    }
}
