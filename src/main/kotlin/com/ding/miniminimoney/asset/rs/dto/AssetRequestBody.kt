package com.ding.miniminimoney.asset.rs.dto

import com.ding.miniminimoney.asset.entities.Asset
import com.ding.miniminimoney.wallet.entities.Wallet

data class AssetRequestBody(
    var name: String,
    var desc: String?,
    var amount: Double,
    var type: String,

)

data class AssetResponseBody(
    var walletKey: String,
    var name: String?,
    var desc: String?,
    var amount: Double,
    var type: String?

)

fun Asset.toAssetResponseBody() = AssetResponseBody(
        name = name,
        walletKey = wallet.walletKey,
        desc = desc,
        amount = amount,
        type = type
)