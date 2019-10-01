package com.dou.javadevdaymx2019.orderservice.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {

    return new RestTemplate();

  }

}
