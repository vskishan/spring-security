package com.example.mfa.sms.controller;

import com.example.mfa.sms.service.MessageService;
import com.example.mfa.sms.service.SMSCodeAuthenticatorService;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControllerForSMSUser {

  @Autowired
  MessageService messageService;

  @Autowired
  SMSCodeAuthenticatorService authenticatorService;

  public String code;

  @GetMapping("/send-sms-code")
  public void sendSMSCode(){
    Random rand = new Random();
    code = Integer.toString(rand.nextInt(100000));
    messageService.sendMessage(code);
  }

  @GetMapping("/get-details-using-sms")
  public String printHelloWorldForSMSUser(@RequestParam(name = "code", required = false) String givenCode){
    authenticatorService.authenticateSMSCode(code, givenCode);
    return "Hello World!";
  }

}
