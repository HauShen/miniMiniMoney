package com.ding.miniminimoney.lds

import feign.Client
import org.springframework.context.annotation.Bean

class FeignConfig {

    @Bean
    fun feignClient(): Client{
        return Client.Default(null, null)
    }
}