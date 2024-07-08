package com.ding.miniminimoney.owe

import com.ding.miniminimoney.owe.entities.Loan
import org.springframework.data.jpa.repository.JpaRepository

interface LoanRepository: JpaRepository<Loan, Long> {
}