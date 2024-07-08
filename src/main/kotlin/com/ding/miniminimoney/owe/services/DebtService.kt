package com.ding.miniminimoney.owe.services

import com.ding.miniminimoney.owe.DebtRepository
import com.ding.miniminimoney.owe.entities.Debt
import com.ding.miniminimoney.owe.rs.dto.DebtRequestBody
import com.ding.miniminimoney.owe.rs.dto.DebtResponseBody
import com.ding.miniminimoney.owe.rs.dto.toDebtResponseBody
import com.ding.miniminimoney.transaction.TransactionRepository
import com.ding.miniminimoney.transaction.entities.Transaction
import com.ding.miniminimoney.transaction.entities.TransactionType
import com.ding.miniminimoney.transaction.rs.dto.TransactionRequestBody
import com.ding.miniminimoney.userprofile.WalletNotCreatedException
import com.ding.miniminimoney.userprofile.services.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class DebtService (
    private val debtRepository: DebtRepository,
    private val userService: UserService
) {

    val logger = LoggerFactory.getLogger(this::class.java)

    fun createDebt (userId: String, debtRequestBody: DebtRequestBody): DebtResponseBody {
        val wallet = userService.getUserByUserIdOrThrow(userId).wallet ?: throw WalletNotCreatedException("Wallet is not created for this user.")

        val debt = Debt(
            wallet = wallet,
            desc = debtRequestBody.desc,
            totalAmount = debtRequestBody.totalAmount,
            monthlyAmount = debtRequestBody.monthlyAmount,
            amountLeft = debtRequestBody.amountLeft ?: debtRequestBody.totalAmount,
            monthlyDueDate = debtRequestBody.monthlyDueDate,
            dateStarted = debtRequestBody.dateStarted,
            debtor = debtRequestBody.debtor,
            name = debtRequestBody.name,
            createdAt = Instant.now(),
        )
        logger.info("Saving info for $userId with the debt $debt")
        debtRepository.save(debt)
        return debt.toDebtResponseBody()
    }
}