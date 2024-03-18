package com.ding.miniminimoney.userprofile.rs.dto

import com.ding.miniminimoney.userprofile.entities.UserProfile
import com.ding.miniminimoney.wallet.entities.Wallet
import java.time.Instant
import java.time.LocalDate

data class UserResponseBody (
        var userId: String? = null,
        var name: String? = null,
        var wallet: Wallet? = null,
        var birthday: LocalDate? = null,
        var createdAt: Instant? = null,
        var createdBy: String? = null,
        var updatedAt: Instant? = null,
        var updatedBy: String? = null,

        )

fun UserProfile.toUserResponseBody() = UserResponseBody(
        userId = userId,
        name = name,
        wallet = wallet,
        birthday = birthday,
        createdAt = createdAt,
        createdBy = createdBy,
        updatedAt = updatedAt,
        updatedBy = updatedBy
)