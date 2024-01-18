package com.ding.miniminimoney.lds

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class LdsService(
        private val ldsFeignClient: LdsFeignClient
) {
    val logger = LoggerFactory.getLogger(this::class.java)

    fun getDetectedLanguage(file: MultipartFile): String{
        return ldsFeignClient.getLangByDocument(file)
                .also{logger.info("hi")}
    }
}