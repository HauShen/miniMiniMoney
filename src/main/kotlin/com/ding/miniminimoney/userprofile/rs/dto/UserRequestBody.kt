package com.ding.miniminimoney.userprofile.rs.dto

import java.time.LocalDate

data class UserRequestBody (
        val userId: String?,
        val name: String,
        val birthday: LocalDate? = null,
)

data class UserUpdateRequestBody (
        var name: String?,
        var birthday: LocalDate? = null,
)
