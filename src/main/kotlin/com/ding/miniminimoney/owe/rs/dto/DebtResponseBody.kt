package com.ding.miniminimoney.owe.rs.dto

import com.ding.miniminimoney.owe.entities.Debt
import java.time.LocalDate

data class DebtResponseBody(
    var desc: String?,
    var totalAmount: Double,
    var monthlyAmount: Double?,
    var amountLeft: Double,
    var name: String?,
    var monthlyDueDate: LocalDate?,
    var dateStarted: LocalDate?,
    var debtor: String,
)

fun Debt.toDebtResponseBody() = DebtResponseBody(
    desc = this.desc,
    totalAmount = this.totalAmount,
    monthlyAmount = this.monthlyAmount,
    amountLeft = this.amountLeft,
    name = this.name,
    monthlyDueDate = this.monthlyDueDate,
    dateStarted = this.dateStarted,
    debtor = this.debtor
)