package com.ding.miniminimoney.owe

import com.ding.miniminimoney.owe.entities.Debt
import org.springframework.data.jpa.repository.JpaRepository

interface DebtRepository: JpaRepository<Debt, Long> {
}