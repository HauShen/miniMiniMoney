package com.ding.miniminimoney.wallet.services

import com.ding.miniminimoney.userprofile.UserNotFoundException
import com.ding.miniminimoney.userprofile.UserProfileRepository
import com.ding.miniminimoney.userprofile.WalletNotCreatedException
import com.ding.miniminimoney.userprofile.rs.dto.UserResponseBody
import com.ding.miniminimoney.userprofile.rs.dto.toUserResponseBody
import com.ding.miniminimoney.userprofile.services.UserService
import com.ding.miniminimoney.wallet.WalletRepository
import com.ding.miniminimoney.wallet.entities.Wallet
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class WalletService(
        private val walletRepository: WalletRepository,
        private val userService: UserService,
        private val userRepository: UserProfileRepository
) {

    val logger = LoggerFactory.getLogger(this::class.java)

//    fun getUserByUserIdOrThrow (userId: String): UserResponseBody {
//        val wallet = userProfileRepository.findByUserId(userId)?: throw Exception("user not found")
//        return user.toUserResponseBody()
//
//    }

    fun createAndAssignWallet (userId: String ): Wallet {

        try {
          val userToBeAssigned =  userService.getUserByUserIdOrThrow(userId)
            val newWallet = Wallet(userProfile = userToBeAssigned)
            userToBeAssigned.wallet = newWallet

            userRepository.save(userToBeAssigned)
            return newWallet
        }
        catch (e: UserNotFoundException)
        {
            logger.warn("Something wrong. The user is not created properly. userId : $userId" )
            throw WalletNotCreatedException("the wallet for $userId cannot be created")
        }
    }
}