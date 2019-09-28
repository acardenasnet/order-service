package com.dou.javadevdaymx2019.orderservice.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class AppConfiguration {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {

    DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory();

    RestTemplate restTemplate = builder.build();
    restTemplate.setUriTemplateHandler(uriBuilderFactory);

    return restTemplate;
  }

}
