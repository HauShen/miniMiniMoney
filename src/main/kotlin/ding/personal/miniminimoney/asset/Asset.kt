package ding.personal.miniminimoney.asset

import java.time.Instant

data class Asset (
    private val id: Long? = null,
    private val name: String? = null,
    private val desc: String? = null,
    private val amount: Double = 0.0,
    private val type: String? = null,
    private val createdAt: Instant? = null,
    private val updatedAt: Instant? = null,
    private val createdBy: String? = null,
    private val updatedBy: String? = null,
){

}