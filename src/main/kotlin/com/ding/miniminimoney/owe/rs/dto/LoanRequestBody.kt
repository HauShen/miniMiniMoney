package com.ding.miniminimoney.owe.rs.dto

import java.time.LocalDate

data class LoanRequestBody(
        var desc: String,
        var totalAmount: Double,
        var monthlyAmount: Double?,
        var amountLeft: Double?,
        var name: String,
        var monthlyDueDate: LocalDate?,
        var dateStarted: LocalDate?,
        var lender: String,
)