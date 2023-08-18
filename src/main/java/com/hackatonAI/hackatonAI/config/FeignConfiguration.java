package com.hackatonAI.hackatonAI.config;

import feign.Feign;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

  private static final int MAX_ATTEMPTS = 4;

  private static final long MAX_PERIOD_BETWEEN_ATTEMPTS = 2000L;

  private static final long START_ATTEMPT = 1000L;

  @Bean
  public Feign.Builder feignBuilder() {
    return Feign.builder().errorDecoder(new FeignClientErrorDecoder());
  }

  @Bean
  public Retryer retryer() {
    return new Retryer.Default(START_ATTEMPT, MAX_PERIOD_BETWEEN_ATTEMPTS, MAX_ATTEMPTS);
  }
}
