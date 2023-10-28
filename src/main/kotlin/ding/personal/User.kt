package ding.personal

import ding.personal.Wallet
import java.time.LocalDate
import java.time.Instant

data class User (
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