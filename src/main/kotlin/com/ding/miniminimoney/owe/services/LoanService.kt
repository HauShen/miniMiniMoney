package com.ding.miniminimoney.owe.services

import com.ding.miniminimoney.owe.DebtRepository
import com.ding.miniminimoney.owe.LoanRepository
import com.ding.miniminimoney.owe.entities.Debt
import com.ding.miniminimoney.owe.entities.Loan
import com.ding.miniminimoney.owe.rs.dto.*
import com.ding.miniminimoney.userprofile.WalletNotCreatedException
import com.ding.miniminimoney.userprofile.services.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class LoanService (
        private val loanRepository: LoanRepository,
        private val userService: UserService
) {

    val logger = LoggerFactory.getLogger(this::class.java)

    fun createLoan (userId: String, loanRequestBody: LoanRequestBody): LoanResponseBody {
        val wallet = userService.getUserByUserIdOrThrow(userId).wallet ?: throw WalletNotCreatedException("Wallet is not created for this user.")

        val loan = Loan(
            wallet = wallet,
            desc = loanRequestBody.desc,
            totalAmount = loanRequestBody.totalAmount,
            monthlyAmount = loanRequestBody.monthlyAmount,
            amountLeft = loanRequestBody.amountLeft ?: loanRequestBody.totalAmount,
            monthlyDueDate = loanRequestBody.monthlyDueDate,
            dateStarted = loanRequestBody.dateStarted,
            lender = loanRequestBody.lender,
            name = loanRequestBody.name,
            createdAt = Instant.now(),
        )
        logger.info("Saving info for $userId with the debt $loan")
        loanRepository.save(loan)
        return loan.toLoanResponseBody()
    }
}