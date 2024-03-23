package com.ding.miniminimoney.asset

import com.ding.miniminimoney.asset.entities.Asset
import org.springframework.data.jpa.repository.JpaRepository

interface AssetRepository: JpaRepository<Asset, Long> {

}