package ding.personal.miniminimoney.scheduler;

import org.slf4j.LoggerFactory
import org.slf4j.helpers.SubstituteLogger
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component;
import java.util.logging.Logger

@Profile("scheduler")
@Component
class MonthlyScheduler (
//        private val monthlyService: MonthlyService,
        private val monthlyCheckConfiguration: MonthlyCheckConfiguration,
){

    val logger = LoggerFactory.getLogger(this::class.java)

    @Scheduled(fixedDelayString = "\${monthly.check.delay}")
    fun monthlyCheck(){
        if(monthlyCheckConfiguration.enabled){
            logger.info("test")
        }
        else{
            print("no")
        }
    }
}

@Component
@ConfigurationProperties(prefix = "monthly.check")
class MonthlyCheckConfiguration {
    var enabled: Boolean = false

}
