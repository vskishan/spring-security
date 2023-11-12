package mfa.sms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SMSSecurityConfig {

  @Bean
  public InMemoryUserDetailsManager smsUserDetailsManager(){
    UserDetails user = User.withDefaultPasswordEncoder()
                          .username("Kishan")
                          .password("password")
                          .build();

    return new InMemoryUserDetailsManager(user);
  }

}
