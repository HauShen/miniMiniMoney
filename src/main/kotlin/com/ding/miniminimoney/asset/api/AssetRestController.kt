package com.ding.miniminimoney.asset.api

import com.ding.miniminimoney.asset.rs.dto.AssetRequestBody
import com.ding.miniminimoney.asset.rs.dto.AssetResponseBody
import com.ding.miniminimoney.asset.rs.dto.toAssetResponseBody
import com.ding.miniminimoney.asset.services.AssetService
import com.ding.miniminimoney.transaction.rs.dto.TransactionCreatedResponseBody
import com.ding.miniminimoney.transaction.rs.dto.TransactionRequestBody
import com.ding.miniminimoney.transaction.rs.dto.toTransactionCreatedResponseBody
import com.ding.miniminimoney.transaction.services.TransactionService
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(
        "/asset"
)
class AssetRestController(
        private val assetService: AssetService
) {
    @PostMapping("/createAsset/{userId}")
    fun createTransaction(

            @PathVariable("userId") userId: String,

            @RequestBody
            createAssetRequestBody: AssetRequestBody

    ): ResponseEntity<AssetResponseBody> {

        val assetCreated = assetService.createAsset(userId, createAssetRequestBody)
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .allow(HttpMethod.GET)
                .body(assetCreated.toAssetResponseBody())
    }

}