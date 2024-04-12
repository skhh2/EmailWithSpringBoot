package com.app.mailSender;

import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public final JavaMailSender javaMailSender;
    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }
    public void sendEmail(String toMail, String subject, String body) {
        var msg = new SimpleMailMessage();
        msg.setTo(toMail);
        msg.setSubject(subject);
        msg.setText(body);
        javaMailSender.send(msg);
        System.out.println("Message Sent Successfully");
    }
}
