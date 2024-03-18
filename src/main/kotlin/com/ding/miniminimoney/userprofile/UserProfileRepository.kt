package com.ding.miniminimoney.userprofile

import com.ding.miniminimoney.userprofile.entities.UserProfile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface UserProfileRepository: JpaRepository<UserProfile, Long> {

    fun findByUserId(userId: String): UserProfile?

    fun findByOid(oid: Long): UserProfile?
}