package com.ding.miniminimoney.transaction.persistence.entities

import com.ding.miniminimoney.wallet.entities.Wallet
import jakarta.persistence.*
import java.time.LocalDate
import java.time.Instant

@Entity
@Table(name = "wallet")
data class Transaction (
        @Id
        val oid: Long? = null,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name= "wallet_oid")
        val wallet: Wallet? = null,
        val desc: String? = null,
        val amount: Double = 0.0,
        val name: String? = null,
        val date: LocalDate? = null,
        val transactionType: TransactionType,
        val createdAt: Instant? = null,
        val updatedAt: Instant? = null,
        val createdBy: String? = null,
        val updatedBy: String? = null,
){
}

enum class TransactionType {
    PAY_BILL,
    COMMITMENT,
    GIFT_FROM,
    GIFT_TO,
    OTHERS_RECEIVE,
    OTHERS_GIVE,
    SALARY,
    WAGES,
    TREAT,
    BUY,
    SELL
}