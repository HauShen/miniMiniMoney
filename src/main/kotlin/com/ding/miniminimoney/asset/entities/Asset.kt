package com.ding.miniminimoney.asset.entities

import com.ding.miniminimoney.wallet.entities.Wallet
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.Instant

@Entity
data class Asset (
        @Id
        @SequenceGenerator(allocationSize = 1, name = "AssetIdSequenceGenerator", sequenceName = "s_asset" )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AssetIdSequenceGenerator")
         val oid: Long = 0,
         val name: String? = null,

        @Column(name = "description")
         val desc: String? = null,

        @Column(name = "amount")
         val amount: Double = 0.0,
         val type: String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "wallet_oid")
         val wallet: Wallet,

         val createdAt: Instant? = null,
         val updatedAt: Instant? = null,
         val createdBy: String? = null,
         val updatedBy: String? = null,
){
    override fun toString(): String =
            "Asset()"

}