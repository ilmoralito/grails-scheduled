package demo

import groovy.transform.CompileStatic

import java.text.SimpleDateFormat

@CompileStatic
class EmailService {

    void send(String user, String message) {
        log.info "Sending email to ${user} : ${message}"+ ' at ' + new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date())
    }
}
