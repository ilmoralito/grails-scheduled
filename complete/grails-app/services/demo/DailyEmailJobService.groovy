package demo

import groovy.transform.CompileStatic
import org.springframework.scheduling.annotation.Scheduled

//tag::dailyEmailJobService[]
@CompileStatic
class DailyEmailJobService  {

    boolean lazyInit = false // <1>

    EmailService emailService // <2>

    @Scheduled(cron = "0 30 4 1/1 * ?") //<4>
    void execute() {
        emailService.send('john.doe@example.com', 'Test Message') // <3>
    }
}
//end::dailyEmailJobService[]