package com.ding.miniminimoney.userprofile.services

import com.ding.miniminimoney.userprofile.UserProfileRepository
import com.ding.miniminimoney.userprofile.rs.dto.UserRequestBody
import com.ding.miniminimoney.userprofile.rs.dto.UserResponseBody
import com.ding.miniminimoney.userprofile.rs.dto.UserUpdateRequestBody
import com.ding.miniminimoney.userprofile.rs.dto.entities.UserProfile
import com.ding.miniminimoney.userprofile.rs.dto.toUserResponseBody
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
        private val userProfileRepository: UserProfileRepository,
) {

    fun getUserByUserId (userId: String): UserResponseBody {
        val user = userProfileRepository.findByUserId(userId)?: throw Exception("user not found")
        return user.toUserResponseBody()

    }

    fun getTest(userId: String): String {
        return Locale(userId).displayLanguage

    }

    fun createUser (userRequestBody: UserRequestBody): UserResponseBody {
        val userProfile = UserProfile(name = userRequestBody.name, birthday = userRequestBody.birthday)
        userProfileRepository.save(userProfile)
        return userProfile.toUserResponseBody()
    }


}