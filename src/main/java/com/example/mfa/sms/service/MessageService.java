package com.example.mfa.sms.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  public void sendMessage(String code){
    Twilio.init(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));

    Message.creator(new PhoneNumber(System.getenv("USER_MOBILE_NUMBER")),
        new PhoneNumber(System.getenv("TWILIO_PHONE_NUMBER")), "Your verification code (Test) : " + code).create();
  }

}
