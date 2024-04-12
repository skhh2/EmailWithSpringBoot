package com.app.mailSender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.app.mailSender.EmailService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailSenderApplication {
	public final EmailService emailService;
	private static String body ="Hi This is Shalini, this is a msg from Spring Application";
	public MailSenderApplication(EmailService emailService){
		this.emailService = emailService;
	}

	public static void main(String[] args) {
		SpringApplication.run(MailSenderApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail(){
		emailService.sendEmail("kandimallashalini@gmail.com", "Test Mail", body);
	}


}
