package ding.personal.miniminimoney.wallet.persistence.entities

import ding.personal.miniminimoney.owe.persistence.entities.Debt
import ding.personal.miniminimoney.owe.persistence.entities.Loan
import ding.personal.miniminimoney.transaction.persistence.entities.Transaction
import ding.personal.miniminimoney.userprofile.asset.persistence.entities.Asset
import ding.personal.miniminimoney.userprofile.persistence.entities.UserProfile
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "wallet")
data class Wallet (
        @Id
     val oid: Long? = null,
        @OneToOne(mappedBy = "wallet")
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