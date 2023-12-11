package ding.personal.miniminimoney.owe

import ding.personal.miniminimoney.wallet.persistence.entities.Wallet
import java.time.Instant
import java.time.LocalDate

abstract class Owe {
    abstract val id: Long?
    abstract val wallet: Wallet?
    abstract val desc: String?
    abstract val amount: Double
    abstract val name: String?
    abstract val monthlyDueDate: LocalDate?
    abstract val dateStarted: LocalDate?
    abstract val createdAt: Instant?
    abstract val updatedAt: Instant?
    abstract val createdBy: String?
    abstract val updatedBy: String?
}

data class Debt(
        override val id: Long?,
        override val wallet: Wallet?,
        override val desc: String?,
        override val amount: Double,
        override val name: String?,
        override val monthlyDueDate: LocalDate?,
        override val dateStarted: LocalDate?,
        override val createdAt: Instant?,
        override val updatedAt: Instant?,
        override val createdBy: String?,
        override val updatedBy: String?,
        val debtor: String,
): Owe(){

}
data class Loan(
        override val id: Long?,
        override val wallet: Wallet?,
        override val desc: String?,
        override val amount: Double,
        override val name: String?,
        override val monthlyDueDate: LocalDate?,
        override val dateStarted: LocalDate?,
        override val createdAt: Instant?,
        override val updatedAt: Instant?,
        override val createdBy: String?,
        override val updatedBy: String?,
        val lender: String,
        val monthlyAmount: Double,
): Owe(){

}