package demo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.scheduling.annotation.Scheduled

import java.text.SimpleDateFormat

@CompileStatic
@Slf4j
class HelloWorldJobService {

    @Scheduled // TODO 10 seconds
    void execute() {

    }

    @Scheduled // TODO 45 secondsw with 5 seconds dealy
    void execute() {

    }
}
