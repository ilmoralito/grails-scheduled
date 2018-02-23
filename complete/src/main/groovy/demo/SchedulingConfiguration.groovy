package demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler

@Configuration //<1>
class SchedulingConfiguration {

    @Bean
    ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler()
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler") //<2>
        threadPoolTaskScheduler.initialize()
        threadPoolTaskScheduler
    }
}
