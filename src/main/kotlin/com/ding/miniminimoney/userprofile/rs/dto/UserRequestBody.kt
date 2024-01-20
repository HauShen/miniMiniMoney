package com.ding.miniminimoney.userprofile.rs.dto

import com.ding.miniminimoney.wallet.persistence.entities.Wallet
import java.time.Instant
import java.time.LocalDate

data class UserRequestBody (
        var name: String,
        var birthday: LocalDate? = null,
)

data class UserUpdateRequestBody (
        var name: String,
        var birthday: LocalDate? = null,
)

data class AnimalRequestBody (
        var name: String,
        var amount: Int,
)

data class AnimalUpdateRequestBody (
        var name: String,
        var amount: Int,
)