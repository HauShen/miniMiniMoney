package com.ding.miniminimoney.transaction.entities

import com.ding.miniminimoney.wallet.entities.Wallet
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import java.time.LocalDate
import java.time.Instant

@Entity
@Table(name = "transaction_record")
data class Transaction (
        @Id
        @SequenceGenerator(allocationSize = 1, name = "TransactionIdSequenceGenerator", sequenceName = "s_transaction" )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TransactionIdSequenceGenerator")
        val oid: Long = 0,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "wallet_oid")
        val wallet: Wallet,

        @Column (name = "description")
        val desc: String? = null,
        val amount: Double = 0.0,
        val name: String,

        @Column(name = "date_of_transaction")
        val date: LocalDate? = null,

        val transactionType: TransactionType,
        val createdAt: Instant? = null,
        val updatedAt: Instant? = null,
        val createdBy: String? = null,
        val updatedBy: String? = null,
){

    override fun toString(): String =
            "Transaction()"
}

enum class TransactionType(val increment: Boolean ) {
    PAY_BILL(false),
    COMMITMENT(false),
    GIFT_FROM(true),
    GIFT_TO(false),
    OTHERS_RECEIVE(true),
    OTHERS_GIVE(false),
    SALARY(true),
    WAGES(true),
    TREAT(false),
    BUY(false),
    SELL(true),
}