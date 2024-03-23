package com.ding.miniminimoney.wallet.entities

import com.ding.miniminimoney.owe.entities.Debt
import com.ding.miniminimoney.owe.entities.Loan
import com.ding.miniminimoney.transaction.entities.Transaction
import com.ding.miniminimoney.asset.entities.Asset
import com.ding.miniminimoney.userprofile.entities.UserProfile
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import org.apache.commons.lang3.builder.ToStringExclude
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

        @Column(name="wallet_key")
        val walletKey: String = UUID.randomUUID().toString(),

        @Column(name="amount")
        val amount: Double = 0.0,

        val createdAt: Instant? = Instant.now(),

        val updatedAt: Instant? = null,

        val createdBy: String? = null,

        val updatedBy: String? = null,

        @ToStringExclude
        @OneToMany(mappedBy = "wallet", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = false)
        val transactionRecords : List<Transaction> = emptyList(),

        @ToStringExclude
        @OneToMany(mappedBy = "wallet", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = false)
        val debt : List<Debt> = emptyList(),

        @ToStringExclude

        @OneToMany(mappedBy = "wallet", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = false)
        val loan : List<Loan> = emptyList(),

        @OneToMany(mappedBy = "wallet", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = false)
        val asset : List<Asset> = emptyList()
){
}