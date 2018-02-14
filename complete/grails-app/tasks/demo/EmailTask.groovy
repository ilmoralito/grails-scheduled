package demo

class EmailTask implements Runnable {

    String email
    EmailService emailService

    EmailTask(EmailService emailService, String email){
        this.emailService = emailService
        this.email = email
    }

    @Override
    void run() {
        emailService.send(email)
    }
}
