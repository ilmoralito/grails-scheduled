package demo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.scheduling.annotation.Scheduled

import java.text.SimpleDateFormat

@Slf4j
@CompileStatic  //<1>
class HelloWorldJobService {

    boolean lazyInit = false //<2>

    @Scheduled(fixedDelay = 10000L) //<3>
    void executeEveryTen() {
        log.info "Simple Job every 10 seconds :{}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date())
    }

    @Scheduled(fixedDelay = 45000L, initialDelay = 5000L) //<4>
    void executeEveryFourtyFive() {
        log.info "Simple Job every 45 seconds :{}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date())
    }
}
