package ding.personal.miniminimoney.userprofile.persistence.entities

import ding.personal.miniminimoney.wallet.persistence.entities.Wallet
import jakarta.persistence.*
import java.time.LocalDate
import java.time.Instant

@Entity
@Table(name = "user_profile")
data class UserProfile (
        @Id
        val oid: Long? =  null,
        val name: String? = null,
        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "wallet_id", referencedColumnName = "oid")
        val wallet: Wallet? = null,
        val birthday: LocalDate? = null,
        val createdAt: Instant? = null,
        val createdBy: String? = null,
        val updatedAt: Instant? = null,
        val updatedBy: String? = null,
){

}