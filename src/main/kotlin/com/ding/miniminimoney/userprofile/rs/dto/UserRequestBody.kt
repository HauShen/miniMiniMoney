package com.ding.miniminimoney.userprofile.rs.dto

import java.time.LocalDate

data class UserRequestBody (
        var name: String,
        var birthday: LocalDate? = null,
)

data class UserUpdateRequestBody (
        var name: String?,
        var birthday: LocalDate? = null,
)
