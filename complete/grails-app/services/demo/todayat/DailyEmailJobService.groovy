package demo.todayat

//tag::dailyEmailJobService[]
//import com.agileorbit.schwartz.SchwartzJob
import demo.EmailService
import demo.EmailTask
import demo.ThreadPoolTaskSchedulerBean
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.scheduling.support.PeriodicTrigger

import javax.annotation.PostConstruct
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

@CompileStatic
@Slf4j
class DailyEmailJobService { // implements SchwartzJob {
    final int HOUR = 4
    final int MINUTE = 30
    final int SECONDS = 0

    ThreadPoolTaskSchedulerBean threadPoolTaskScheduler // <1>
    EmailService emailService // <2>

//    void execute(JobExecutionContext context) throws JobExecutionException {
//        emailService.send('john.doe@example.com')
//    }
    @PostConstruct
    void todayAt() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1)

        Period p = Period.between(today, birthday);
        long p2 = ChronoUnit.DAYS.between(today, birthday);
        println("You are " + p.getYears() + " years, " + p.getMonths() +
                " months, and " + p.getDays() +
                " days old. (" + p2 + " days total)");

//        threadPoolTaskScheduler
//            .threadPoolTaskScheduler()
//            .schedule(new EmailTask(emailService, 'john.doe@example.com'), dailyDate(), )
    }

    Instant dailyDate() {
        Date startAt = new Date(hours: HOUR, minutes: MINUTE, seconds: SECONDS)
        if(startAt.before(new Date())) {
            return (startAt + 1).toInstant()
        }
        startAt.toInstant()
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