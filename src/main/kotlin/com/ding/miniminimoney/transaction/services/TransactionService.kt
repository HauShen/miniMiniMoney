package com.ding.miniminimoney.transaction.services

import com.ding.miniminimoney.transaction.TransactionRepository
import com.ding.miniminimoney.transaction.entities.Transaction
import com.ding.miniminimoney.transaction.entities.TransactionType
import com.ding.miniminimoney.transaction.rs.dto.TransactionRequestBody
import com.ding.miniminimoney.userprofile.WalletNotCreatedException
import com.ding.miniminimoney.userprofile.services.UserService
import com.ding.miniminimoney.wallet.entities.Wallet
import com.ding.miniminimoney.wallet.services.WalletService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class TransactionService(
        private val transactionRepository: TransactionRepository,
        private val userService: UserService
) {

    val logger = LoggerFactory.getLogger(this::class.java)

    fun createTransaction (userId: String, transactionRequestBody: TransactionRequestBody): Transaction {
        val wallet = userService.getUserByUserIdOrThrow(userId).wallet ?: throw WalletNotCreatedException("Wallet is not created for this user.")

        val transaction = Transaction(
                wallet = wallet,
                desc = transactionRequestBody.desc,
                amount = incrementOrDecrement(transactionRequestBody.amount, TransactionType.valueOf(transactionRequestBody.transactionType)),
                transactionType = TransactionType.valueOf(transactionRequestBody.transactionType.uppercase()),
                date = transactionRequestBody.date,
                name = transactionRequestBody.name,
                createdAt = Instant.now(),
        )
        logger.info("Saving info for $userId with the transaction $transaction")
        transactionRepository.save(transaction)
        return transaction
    }

    private fun incrementOrDecrement(amount: Double, transactionType: TransactionType): Double{
       return if (!transactionType.increment){
           "%.2f".format(-amount).toDouble()
        } else "%.2f".format(amount).toDouble()
    }
}