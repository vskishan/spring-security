package mfa.mail.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MailSecurityConfig {

  @Bean
  public InMemoryUserDetailsManager mailUserDetailsManager(){
    UserDetails user = User.withDefaultPasswordEncoder()
                          .username("Kishan")
                          .password("password")
                          .build();

    return new InMemoryUserDetailsManager(user);
  }

}
