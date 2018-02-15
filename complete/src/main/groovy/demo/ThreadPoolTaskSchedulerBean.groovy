package demo

import org.springframework.context.annotation.Bean
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler

class ThreadPoolTaskSchedulerBean {

    @Bean
    ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler()
        threadPoolTaskScheduler.setPoolSize(5) //<1>
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler") //<2>
        threadPoolTaskScheduler.initialize()
        threadPoolTaskScheduler
    }
}
