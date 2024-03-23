package com.ding.miniminimoney.transaction.rs.dto

import com.ding.miniminimoney.transaction.entities.Transaction
import java.time.LocalDate

data class TransactionRequestBody (
    var name: String,
    var desc: String?,
    var amount: Double,
    var transactionType: String,
    var date: LocalDate = LocalDate.now()

)

data class TransactionCreatedResponseBody (
    var name: String,
    var walletKey: String,
    var desc: String?,
    var amount: Double,
    var transactionType: String,
    var walletAmount: Double,
    var date: LocalDate = LocalDate.now()

)

fun Transaction.toTransactionCreatedResponseBody() = TransactionCreatedResponseBody(
    name = name,
    walletKey = wallet.walletKey,
    desc = desc,
    amount = amount,
    transactionType = transactionType.name,
    walletAmount = wallet.amount,
    date = date!!

)
