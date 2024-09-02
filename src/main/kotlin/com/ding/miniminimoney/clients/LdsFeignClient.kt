package com.ding.miniminimoney.clients

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(
        name = "lds",
        url = "https://eqj08bsljrc.execute-api.eu-west-1.amazonaws.com",
        configuration = [LdsCustomErrorDecoder::class]
)
interface LdsFeignClient {

    @PostMapping("/language/detect/pdfs")
    fun getLangByDocument(
            file: ByteArray
    ): ResponseEntity<String>

}