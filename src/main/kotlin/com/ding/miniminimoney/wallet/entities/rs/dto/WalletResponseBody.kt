package com.ding.miniminimoney.wallet.entities.rs.dto

import com.ding.miniminimoney.asset.entities.Asset
import com.ding.miniminimoney.owe.entities.Debt
import com.ding.miniminimoney.owe.entities.Loan
import com.ding.miniminimoney.transaction.entities.Transaction
import com.ding.miniminimoney.wallet.entities.Wallet

data class WalletResponseBody(
        var walletKey: String? = null,
        var amount: Double? = null,
        var debt : List<Debt>? = null,
        var loan: List<Loan>? = null,
        var asset : List<Asset>? = null,
        )

fun Wallet.toWalletResponseBody() = WalletResponseBody(
    walletKey = walletKey,
    amount = amount,
    debt = debt,
    loan = loan,
    asset = asset
)