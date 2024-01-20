package com.ding.miniminimoney.scheduler.lds

import feign.Client
import feign.codec.ErrorDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {

    @Bean
    fun feignClient(): Client{
        return Client.Default(null, null)
    }

    @Bean
    fun errorDecoder(): ErrorDecoder {
        return CustomErrorDecoder()
    }
}