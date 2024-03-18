package com.ding.miniminimoney.wallet.entities

import com.ding.miniminimoney.owe.persistence.entities.Debt
import com.ding.miniminimoney.owe.persistence.entities.Loan
import com.ding.miniminimoney.transaction.persistence.entities.Transaction
import com.ding.miniminimoney.asset.entities.Asset
import com.ding.miniminimoney.userprofile.entities.UserProfile
import jakarta.persistence.*
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "wallet")
data class Wallet (
        @Id
        @SequenceGenerator(allocationSize = 1, name = "WalletIdSequenceGenerator", sequenceName = "s_wallet" )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WalletIdSequenceGenerator")
        @Column(name="oid")
        val oid: Long = 0,

        val walletId: String = UUID.randomUUID().toString(),

        @OneToOne(mappedBy = "wallet", fetch = FetchType.LAZY)
        val userProfile: UserProfile,

        val amount: Double = 0.0,
        val createdAt: Instant? = null,
        val updatedAt: Instant? = null,
        val createdBy: String? = null,
        val updatedBy: String? = null,
        @OneToMany(mappedBy = "wallet", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = false)
        val transactionRecords : MutableList<Transaction> = mutableListOf(),
        @OneToMany(mappedBy = "wallet", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = false)
        val debt : MutableList<Debt> = mutableListOf(),
        @OneToMany(mappedBy = "wallet", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = false)
        val loan : MutableList<Loan> = mutableListOf(),
        @OneToMany(mappedBy = "wallet", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = false)
        val asset : MutableList<Asset> = mutableListOf()
){
}