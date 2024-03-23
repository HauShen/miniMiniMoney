package com.ding.miniminimoney.owe.entities

import com.ding.miniminimoney.wallet.entities.Wallet
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.Instant
import java.time.LocalDate

abstract class Owe {
    abstract val oid: Long?
    abstract val wallet: Wallet?
    abstract val desc: String?
    abstract val totalAmount: Double
    abstract val monthlyAmount: Double
    abstract val amountLeft: Double
    abstract val name: String?
    abstract val monthlyDueDate: LocalDate?
    abstract val dateStarted: LocalDate?
    abstract val createdAt: Instant?
    abstract val updatedAt: Instant?
    abstract val createdBy: String?
    abstract val updatedBy: String?
}

@Entity
@Table(name = "debt")
data class Debt(
        @SequenceGenerator(allocationSize = 1, name = "DebtIdSequenceGenerator", sequenceName = "s_debt" )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DebtIdSequenceGenerator")
        @Id
        override val oid: Long?,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name= "wallet_oid")
        @JsonIgnore
        override val wallet: Wallet?,

        @Column (name = "description")
        override val desc: String?,
        override val totalAmount: Double,
        override val monthlyAmount: Double,
        override val amountLeft: Double,
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

@Entity
@Table(name = "loan")
data class Loan(
        @SequenceGenerator(allocationSize = 1, name = "LoanIdSequenceGenerator", sequenceName = "s_loan" )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LoanIdSequenceGenerator")
        @Id
        override val oid: Long?,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name= "wallet_oid")
        @JsonIgnore
        override val wallet: Wallet?,

        @Column (name = "description")
        override val desc: String?,
        override val totalAmount: Double,
        override val monthlyAmount: Double,
        override val amountLeft: Double,
        override val name: String?,
        override val monthlyDueDate: LocalDate?,
        override val dateStarted: LocalDate?,
        override val createdAt: Instant?,
        override val updatedAt: Instant?,
        override val createdBy: String?,
        override val updatedBy: String?,
        val lender: String,
): Owe(){

}