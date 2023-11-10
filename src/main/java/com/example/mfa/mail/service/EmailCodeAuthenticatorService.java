package com.example.mfa.mail.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class EmailCodeAuthenticatorService {

  public void authenticateEmailCode(String actualCode, String suppliedCode){
    if(!actualCode.equals(suppliedCode)){
      throw new BadCredentialsException("Invalid SMS code supplied!!");
    }
  }

}
