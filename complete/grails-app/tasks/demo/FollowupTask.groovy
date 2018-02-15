package demo

import java.text.SimpleDateFormat

class FollowupTask implements Runnable { //<1>

    String email //<2>
    EmailService emailService //<3>

    FollowupTask(EmailService emailService, String email) { //<4>
        this.emailService = emailService
        this.email = email
    }

    @Override
    void run() { //<5>
        println 'Sending followup email to: ' + email + ' at ' + new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date())
        //emailService.send(email)
    }
}
