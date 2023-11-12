package mfa.mail.controller;

import com.mfa.mail.service.EmailService;
import com.mfa.mail.service.EmailCodeAuthenticatorService;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControllerForMailUser {

  @Autowired
  EmailService messageService;

  @Autowired
  EmailCodeAuthenticatorService authenticatorService;

  public String code;

  @GetMapping("/send-mail-code")
  public void sendMailCode(){
    Random rand = new Random();
    code = Integer.toString(rand.nextInt(100000));
    messageService.sendEmailCode(code);
  }

  @GetMapping("/get-detail-using-mail")
  public String printHelloWorldForSMSUser(@RequestParam(name = "code", required = false) String givenCode){
    authenticatorService.authenticateEmailCode(code, givenCode);
    return "Hello World!";
  }

}
