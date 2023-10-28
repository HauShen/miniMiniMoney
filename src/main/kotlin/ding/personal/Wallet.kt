package ding.personal

import java.time.Instant

data class Wallet (
    private val id: Long? = null,
    private val amount: Double = 0.0,
    private val createdAt: Instant? = null,
    private val updatedAt: Instant? = null,
    private val createdBy: String? = null,
    private val updatedBy: String? = null,
){
}