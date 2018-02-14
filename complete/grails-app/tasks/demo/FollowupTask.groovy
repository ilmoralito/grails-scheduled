package demo

import java.text.SimpleDateFormat

class FollowupTask implements Runnable {
    String email
    EmailService emailService

    FollowupTask(EmailService emailService, String email){
        this.emailService = emailService
        this.email = email
    }

    @Override
    void run() {
        println 'Sending followup email to: ' + email + ' at ' + new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date())
        //emailService.send(email)
    }
}
