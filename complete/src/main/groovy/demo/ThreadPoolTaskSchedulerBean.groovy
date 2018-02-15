package demo

import org.springframework.context.annotation.Bean
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.scheduling.support.PeriodicTrigger

import java.util.concurrent.TimeUnit

class ThreadPoolTaskSchedulerBean {

    @Bean
    ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler()
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler") //<1>
        threadPoolTaskScheduler.initialize()
        threadPoolTaskScheduler
    }
}
