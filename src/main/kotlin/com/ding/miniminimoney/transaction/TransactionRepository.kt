package com.ding.miniminimoney.transaction

import com.ding.miniminimoney.transaction.entities.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository: JpaRepository<Transaction, Long> {
}