package ding.personal.miniminimoney.userprofile.persistence.entities

import ding.personal.miniminimoney.wallet.persistence.entities.Wallet
import jakarta.persistence.Entity
import java.time.LocalDate
import java.time.Instant

@Entity
data class UserProfile (
        val id: Long? = null,
        val name: String? = null,
        val wallet: Wallet? = null,
        val birthday: LocalDate? = null,
        val createdAt: Instant? = null,
        val createdBy: String? = null,
        val updatedAt: Instant? = null,
        val updatedBy: String? = null,
){

}