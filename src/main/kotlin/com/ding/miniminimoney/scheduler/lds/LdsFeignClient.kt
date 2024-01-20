package com.ding.miniminimoney.scheduler.lds

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@FeignClient(
        name = "lds",
        url = "https://eqj08bljrc.execute-api.eu-west-1.amazonaws.com",
        configuration = [FeignConfig::class]
)
interface LdsFeignClient {

    @PostMapping("/language/detect/pdf")
    fun getLangByDocument(
            file: ByteArray
    ): ResponseEntity<String>

}