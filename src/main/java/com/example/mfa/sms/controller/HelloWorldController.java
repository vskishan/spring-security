package com.example.mfa.controller;

import com.example.mfa.service.MessageService;
import com.example.mfa.service.SMSCodeAuthenticatorService;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @Autowired
  MessageService messageService;

  @Autowired
  SMSCodeAuthenticatorService authenticatorService;

  public String code;

  @GetMapping("/send-code")
  public void sendCode(){
    Random rand = new Random();
    code = Integer.toString(rand.nextInt(100000));
    messageService.sendMessage(code);
  }

  @GetMapping("/hello-world")
  public String printHelloWorld(@RequestParam(name = "code", required = false) String givenCode){
    authenticatorService.authenticateSMSCode(code, givenCode);
    return "Hello World!";
  }

}
