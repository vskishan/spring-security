package mfa.sms.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeAuthenticatorService {

  public void authenticateSMSCode(String actualCode, String suppliedCode){
    if(!actualCode.equals(suppliedCode)){
      throw new BadCredentialsException("Invalid SMS code supplied!!");
    }
  }

}
