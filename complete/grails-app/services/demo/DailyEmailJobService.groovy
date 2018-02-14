package demo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.scheduling.annotation.Scheduled

//tag::dailyEmailJobService[]
@CompileStatic
@Slf4j
class DailyEmailJobService  {

    EmailService emailService // <1>

    @Scheduled  // TODO cron "0 30 4 1/1 * ? *"
    void execute() {
        emailService.send('john.doe@example.com') // <2>
    }
}
//end::dailyEmailJobService[]