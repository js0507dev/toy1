package com.js0507dev.api2.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
  public static final String EXCHANGE_NAME = "sample.exchange";
  public static final String QUEUE_NAME = "sample.queue";
  public static final String ROUTING_KEY = "sample.route";
  public static final String DEAD_LETTER_EXCHANGE_NAME = "sample.dead_letter.exchange";

  @Bean
  TopicExchange exchange() {
    return ExchangeBuilder
        .topicExchange(EXCHANGE_NAME)
        .build();
  }

  @Bean
  Queue queue() {
    return QueueBuilder
        .durable(QUEUE_NAME)
        .deadLetterExchange(DEAD_LETTER_EXCHANGE_NAME)
        .build();
  }

  @Bean
  Binding binding() {
    return BindingBuilder
        .bind(queue())
        .to(exchange())
        .with(ROUTING_KEY);
  }

  @Bean
  public MessageConverter converter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  AmqpTemplate template(ConnectionFactory connectionFactory) {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(converter());
    return rabbitTemplate;
  }
}
