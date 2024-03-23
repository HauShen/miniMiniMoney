package com.ding.miniminimoney.wallet.services

import com.ding.miniminimoney.userprofile.UserNotFoundException
import com.ding.miniminimoney.userprofile.UserProfileRepository
import com.ding.miniminimoney.userprofile.WalletCreationFailedException
import com.ding.miniminimoney.userprofile.WalletNotCreatedException
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


    fun createAndAssignWallet (userId: String): Wallet {

        try {

            // check if user exists
            val userToBeAssigned =  userService.getUserByUserIdOrThrow(userId)

            if (userToBeAssigned.wallet != null) {
                logger.info("Wallet already exists for $userId.")
                return userToBeAssigned.wallet!!
            }
            else {
                var wallet = Wallet()
                userToBeAssigned.wallet = wallet

                userRepository.save(userToBeAssigned)
                return wallet
            }
        }
        catch (e: UserNotFoundException)
        {
            logger.warn("Something wrong. The user is not created properly. userId : $userId" )
            throw WalletCreationFailedException("The wallet for $userId cannot be created because the user is not found.")
        }
    }
}