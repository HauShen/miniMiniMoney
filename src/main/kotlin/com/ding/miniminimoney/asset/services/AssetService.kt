package com.ding.miniminimoney.asset.services

import com.ding.miniminimoney.asset.AssetRepository
import com.ding.miniminimoney.asset.entities.Asset
import com.ding.miniminimoney.asset.rs.dto.AssetRequestBody
import com.ding.miniminimoney.transaction.entities.Transaction
import com.ding.miniminimoney.transaction.entities.TransactionType
import com.ding.miniminimoney.transaction.rs.dto.TransactionRequestBody
import com.ding.miniminimoney.userprofile.WalletNotCreatedException
import com.ding.miniminimoney.userprofile.services.UserService
import com.ding.miniminimoney.wallet.services.WalletService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class AssetService(
        private val assetRepository: AssetRepository,
        private val userService: UserService
        ) {

    val logger = LoggerFactory.getLogger(this::class.java)

    fun createAsset (userId: String, assetRequestBody: AssetRequestBody): Asset {

        val wallet = userService.getUserByUserIdOrThrow(userId).wallet ?: throw WalletNotCreatedException("Wallet is not created for this user.")

        val asset = Asset(
                name = assetRequestBody.name,
                desc = assetRequestBody.desc,
                type = assetRequestBody.type,
                amount = "%.2f".format(assetRequestBody.amount).toDouble(),
                wallet = wallet,
                createdAt = Instant.now()
        )
        logger.info("Saving asset for $userId with the transaction $asset")
        assetRepository.save(asset)
        return asset
    }


}