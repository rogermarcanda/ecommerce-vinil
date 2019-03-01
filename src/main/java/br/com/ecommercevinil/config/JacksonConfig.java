package br.com.ecommercevinil.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

  @Bean
  public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
    ObjectMapper objectMapper = builder.createXmlMapper(false).build();

    // Some other custom configuration for supporting Java 8 features
    objectMapper.registerModule(new Jdk8Module());
    objectMapper.registerModule(new JavaTimeModule());

    // Use property
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

    return objectMapper;
  }
}