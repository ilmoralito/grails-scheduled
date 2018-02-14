package demo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.scheduling.annotation.Scheduled

//tag::dailyEmailJobService[]
@CompileStatic
@Slf4j
class DailyEmailJobService  {

    private static final String sec = 5
    private static final String CRON = "0 30 4 1/1 * ? *"
    private static final String TESTCRON = "*/5 * * * * ?"

    boolean lazyInit = false // <1>

    EmailService emailService // <2>

    @Scheduled(cron = "*/5 * * * * ?") //<4>
    void execute() {
        emailService.send('john.doe@example.com') // <3>
    }
}
//end::dailyEmailJobService[]