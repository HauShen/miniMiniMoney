package com.ding.miniminimoney.userprofile.services

import com.ding.miniminimoney.userprofile.UserProfileRepository
import com.ding.miniminimoney.userprofile.rs.dto.*
import com.ding.miniminimoney.userprofile.rs.dto.entities.UserProfile
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userProfileRepository: UserProfileRepository
) {

    fun getUserByUserId (userId: String): UserResponseBody {
        val user = userProfileRepository.findByUserId(userId)?: throw Exception("user not found")
        return user.toUserResponseBody()

    }


    fun createUser (userRequestBody: UserRequestBody): UserResponseBody {
        val userProfile = UserProfile(name = userRequestBody.name, birthday = userRequestBody.birthday)
        userProfileRepository.save(userProfile)
        return userProfile.toUserResponseBody()
    }

}