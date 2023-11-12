package mfa.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  @Value("${spring.mail.username}") private String sender;
  @Value("${USER_MAIL_ID}") private String receiver;

  @Autowired
  JavaMailSenderImpl javaMailSender;

  public void sendEmailCode(String code){
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    mailMessage.setTo(sender);
    mailMessage.setTo(receiver);
    mailMessage.setSubject("Code to verify (Test Scenario)");
    mailMessage.setText(code);

    javaMailSender.send(mailMessage);
  }

}
