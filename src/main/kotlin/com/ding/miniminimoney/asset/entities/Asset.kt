package com.ding.miniminimoney.asset.entities

import com.ding.miniminimoney.wallet.persistence.entities.Wallet
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.Instant

@Entity
data class Asset (
        @Id
    private val oid: Long,
        private val name: String? = null,
        private val desc: String? = null,
        private val amount: Double = 0.0,
        private val type: String? = null,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name= "wallet_oid")
        private val wallet: Wallet,
        private val createdAt: Instant? = null,
        private val updatedAt: Instant? = null,
        private val createdBy: String? = null,
        private val updatedBy: String? = null,
){

}