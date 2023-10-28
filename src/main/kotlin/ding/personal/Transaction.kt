package ding.personal

import ding.personal.Wallet
import java.time.LocalDate
import ding.personal.TransactionType
import java.time.Instant

data class Transaction (
     val id: Long? = null,
     val wallet: Wallet? = null,
     val desc: String? = null,
     val amount: Double = 0.0,
     val name: String? = null,
     val date: LocalDate? = null,
     val transactionType: TransactionType,
     val createdAt: Instant? = null,
     val updatedAt: Instant? = null,
     val createdBy: String? = null,
     val updatedBy: String? = null,
){
}

enum class TransactionType {
    PAY_BILL,
    COMMITMENT,
    GIFT_FROM,
    GIFT_TO,
    OTHERS_RECEIVE,
    OTHERS_GIVE,
    SALARY,
    WAGES,
    TREAT,
    BUY,
    SELL
}