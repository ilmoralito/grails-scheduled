package demo

class EmailTask implements Runnable { //<1>

    String email //<2>
    EmailService emailService //<3>

    EmailTask(EmailService emailService, String email) { //<4>
        this.emailService = emailService
        this.email = email
    }

    @Override
    void run() { //<5>
        emailService.send(email)
    }
}
