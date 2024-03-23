package com.ding.miniminimoney.scheduler.lds

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class LdsService(
        private val ldsFeignClient: LdsFeignClient
) {
    val logger = LoggerFactory.getLogger(this::class.java)

    fun getDetectedLanguage(file: ByteArray): String{
        try{
             val response = ldsFeignClient.getLangByDocument(file)
                    .also{logger.info(it.statusCode.toString())}

            return response.body!!

        }
        catch (e: LdsCustomErrorDecoder.NotFoundException) {
            logger.warn("lds configuration issue $e")
            throw Exception("API resource cannot be found. Try to check the endpoint. $e")
        }
        catch (e: Throwable) {
            print ("lds not found")
            logger.warn("Unknown host exception $e")
            return "Hi"
        }

    }
}