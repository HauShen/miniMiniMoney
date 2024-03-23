package com.ding.miniminimoney.wallet

import com.ding.miniminimoney.wallet.entities.Wallet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

interface WalletRepository: JpaRepository<Wallet, Long> {
}