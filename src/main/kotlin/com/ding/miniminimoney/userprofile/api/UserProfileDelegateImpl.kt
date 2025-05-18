package com.ding.miniminimoney.userprofile.api

import com.ding.miniminimoney.api.generated.UserProfileApi
import com.ding.miniminimoney.model.generated.UserRequestBody
import com.ding.miniminimoney.model.generated.UserResponseBody
import com.ding.miniminimoney.model.generated.UserUpdateRequestBody
import com.ding.miniminimoney.userprofile.rs.dto.toUserResponseBody
import com.ding.miniminimoney.userprofile.services.UserService
import com.ding.miniminimoney.wallet.entities.rs.dto.toWalletResponseBody
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class UserProfileDelegateImpl(
    private val userService: UserService
) : UserProfileApi {

    override fun createUser(userRequestBody: UserRequestBody): ResponseEntity<UserResponseBody> {
        val createdUser = userService.createUser(
            UserRequestBody(
                userId = userRequestBody.userId,
                name = userRequestBody.name,
                birthday = userRequestBody.birthday
            )
        )
        return ResponseEntity(HttpStatus.CREATED)
    }

    override fun getUser(userId: String): ResponseEntity<UserResponseBody> {
        val user = userService.getUserByUserIdOrThrow(userId)
        return ResponseEntity.ok(
            UserResponseBody(
                userId = user.userId,
                name = user.name,
                birthday = user.birthday,
                wallet = user.wallet?.let {
                    com.ding.miniminimoney.model.generated.Wallet(
                        walletKey = it.walletKey,
                        amount = it.amount
                    )
                }
            )
        )
    }

    override fun updateUser(userId: String, userUpdateRequestBody: UserUpdateRequestBody): ResponseEntity<UserResponseBody> {
        val updatedUser = userService.updateUser(
            UserUpdateRequestBody(
                name = userUpdateRequestBody.name,
                birthday = userUpdateRequestBody.birthday
            ),
            userId
        )
        return ResponseEntity.ok(UserResponseBody(updatedUser.userId, updatedUser.name, updatedUser.birthday))
    }
}