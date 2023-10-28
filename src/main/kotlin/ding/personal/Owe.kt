package ding.personal

import java.time.Instant
import java.time.LocalDate

abstract class Owe {
     val id: Long? = null
     val wallet: Wallet? = null
     val desc: String? = null
     val amount = 0.0
     val name: String? = null
     val monthlyDueDate: LocalDate? = null
     val dateStarted: LocalDate? = null
     val transactionType: Enum<TransactionType>? = null
     val createdAt: Instant? = null
     val updatedAt: Instant? = null
     val createdBy: String? = null
     val updatedBy: String? = null
}