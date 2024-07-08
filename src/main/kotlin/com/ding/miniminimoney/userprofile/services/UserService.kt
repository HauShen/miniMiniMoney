package com.ding.miniminimoney.userprofile.services

import com.ding.miniminimoney.userprofile.UserNotFoundException
import com.ding.miniminimoney.userprofile.UserProfileRepository
import com.ding.miniminimoney.userprofile.rs.dto.*
import com.ding.miniminimoney.userprofile.entities.UserProfile
import org.apache.catalina.User
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class UserService(
        private val userProfileRepository: UserProfileRepository
) {

    val logger = LoggerFactory.getLogger(this::class.java)

    fun getUserByUserIdOrThrow (userId: String): UserProfile {
        val user = userProfileRepository.findByUserId(userId)?: throw UserNotFoundException("User not found/registered.").also {
            logger.warn("User with $userId not found.")
        }
        return user

    }

    fun createUser (userRequestBody: UserRequestBody): UserProfile {

        val userId = userRequestBody.userId ?: UUID.randomUUID().toString()

        val userProfile = UserProfile(userId = userId, name = userRequestBody.name, birthday = userRequestBody.birthday)
        logger.info("User is created with ${userProfile.userId} with name: ${userProfile.name} and birthday: ${userProfile.birthday} not found.")
        userProfileRepository.save(userProfile)
        return userProfile
    }

    fun updateUser (userUpdateRequestBody: UserUpdateRequestBody, userId: String): UserProfile {
        val currentUserProfile = userProfileRepository.findByUserId(userId)

        if (currentUserProfile == null){
            val msg = "user with UserId $userId does not exist"
            logger.warn(msg)
            throw UserNotFoundException(msg)
        }
        val newUserProfile = mergeChangesWithUserProfile(userUpdateRequestBody, currentUserProfile.copy())

        userProfileRepository.save(newUserProfile)
        return currentUserProfile
    }

    private fun mergeChangesWithUserProfile(userUpdateRequestBody: UserUpdateRequestBody, oldUserProfile: UserProfile): UserProfile {
        oldUserProfile.name = userUpdateRequestBody.name ?: oldUserProfile.name
        oldUserProfile.birthday = userUpdateRequestBody.birthday ?: userUpdateRequestBody.birthday
        oldUserProfile.updatedAt =  Instant.now()
        return oldUserProfile
    }

}