package demo

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.scheduling.support.CronTrigger
import org.springframework.scheduling.support.PeriodicTrigger

import java.util.concurrent.TimeUnit

class ThreadPoolTaskSchedulerBean {
    //https://gist.github.com/yarosla/e1cfe46087a93c2fa3b0d8ec49595dd3

    ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler()
        threadPoolTaskScheduler.setPoolSize(5)
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler")
        threadPoolTaskScheduler.initialize()
        threadPoolTaskScheduler
    }

    CronTrigger cronTrigger() {
        return new CronTrigger("10 * * * * ?");
    }

    PeriodicTrigger periodicTrigger() {
        return new PeriodicTrigger(2000, TimeUnit.MICROSECONDS);
    }

    PeriodicTrigger periodicFixedDelayTrigger() {
        PeriodicTrigger periodicTrigger = new PeriodicTrigger(2000, TimeUnit.MICROSECONDS);
        periodicTrigger.setFixedRate(true);
        periodicTrigger.setInitialDelay(1000);
        return periodicTrigger;
    }
}
