package com.ding.miniminimoney

import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignAutoConfiguration
import org.springframework.scheduling.annotation.EnableScheduling

SpringBootApplication
@EnableScheduling
@EnableFeignClients(basePackageClasses = )
@ImportAutoConfiguration(FeignAutoConfiguration::class)
class MiniMiniMoneyApplication

fun main(args: Array<String>) {
	runApplication<MiniMiniMoneyApplication>(*args)
}
