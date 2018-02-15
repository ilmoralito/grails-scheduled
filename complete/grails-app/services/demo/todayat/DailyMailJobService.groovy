package demo.todayat

//tag::dailyEmailJobService[]
//import com.agileorbit.schwartz.SchwartzJob
import demo.EmailService
import demo.EmailTask
import demo.ThreadPoolTaskSchedulerBean
import groovy.time.TimeCategory
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.scheduling.support.PeriodicTrigger

import javax.annotation.PostConstruct
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.Month
import java.time.Period
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit

//import org.quartz.JobExecutionContext
//import org.quartz.JobExecutionException
//import static org.quartz.DateBuilder.todayAt
//import static org.quartz.DateBuilder.tomorrowAt

@Slf4j
@CompileStatic
class DailyMailJobService { // implements SchwartzJob {
    private final int HOUR = 4
    private final int MINUTE = 30
    private final int SECONDS = 0
    private static final long MILLISECONDS_IN_DAY = Duration.ofDays(1).getSeconds() * 1000 //<4>

    ThreadPoolTaskScheduler threadPoolTaskScheduler // <1>
    EmailService emailService // <2>

//    void execute(JobExecutionContext context) throws JobExecutionException {
//        emailService.send('john.doe@example.com')
//    }

    void register(String email, String message) {
        scheduleDailyEmail(email, message)
    }

    void scheduleDailyEmail(String email, String message) { //<5>
        threadPoolTaskScheduler.scheduleAtFixedRate(new EmailTask(emailService, email, message), dailyDate(), MILLISECONDS_IN_DAY)
    }

    Date dailyDate() { //<3>
        Date startAt = new Date(hours: HOUR, minutes: MINUTE, seconds: SECONDS)
        if(startAt.before(new Date())) {
            return (startAt + 1)
        }
        startAt
    }

//
//    void buildTriggers() {
//        Date startAt = dailyDate()
//        triggers << factory('Daily email job')
//                .startAt(startAt)
//                .intervalInDays(1)
//                .build()
//
//    }
}
//end::dailyEmailJobService[]