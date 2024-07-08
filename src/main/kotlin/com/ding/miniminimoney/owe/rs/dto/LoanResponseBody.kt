package com.ding.miniminimoney.owe.rs.dto

import com.ding.miniminimoney.owe.entities.Debt
import com.ding.miniminimoney.owe.entities.Loan
import java.time.LocalDate

class LoanResponseBody (
    var desc: String?,
    var totalAmount: Double,
    var monthlyAmount: Double?,
    var amountLeft: Double,
    var name: String?,
    var monthlyDueDate: LocalDate?,
    var dateStarted: LocalDate?,
    var lender: String,
)
fun Loan.toLoanResponseBody() = LoanResponseBody(
        desc = this.desc,
        totalAmount = this.totalAmount,
        monthlyAmount = this.monthlyAmount,
        amountLeft = this.amountLeft,
        name = this.name,
        monthlyDueDate = this.monthlyDueDate,
        dateStarted = this.dateStarted,
        lender = this.lender
)