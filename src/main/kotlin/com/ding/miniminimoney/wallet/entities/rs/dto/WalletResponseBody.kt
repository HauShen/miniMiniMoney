package com.ding.miniminimoney.wallet.entities.rs.dto

import com.ding.miniminimoney.asset.entities.Asset
import com.ding.miniminimoney.owe.persistence.entities.Debt
import com.ding.miniminimoney.owe.persistence.entities.Loan
import com.ding.miniminimoney.transaction.persistence.entities.Transaction
import com.ding.miniminimoney.userprofile.entities.UserProfile
import com.ding.miniminimoney.wallet.entities.Wallet

data class WalletResponseBody(
        var walletId: String? = null,
        var userProfile: UserProfile? = null,
        var transactionRecords: MutableList<Transaction> ? = null,
        var debt : MutableList<Debt>? = null,
        var loan: MutableList<Loan>? = null,
        var asset : MutableList<Asset>? = null,
        )

fun Wallet.toWalletResponseBody() = WalletResponseBody(
    walletId = walletId.toString(),
    userProfile = userProfile,
    transactionRecords = transactionRecords,
    debt = debt,
    loan = loan,
    asset = asset
)