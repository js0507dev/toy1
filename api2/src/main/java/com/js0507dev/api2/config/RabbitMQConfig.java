package com.js0507dev.api2.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class RabbitMQConfig {
  private final RabbitMQProperties rabbitMQProperties;

  @Bean
  TopicExchange exchange() {
    return ExchangeBuilder
        .topicExchange(rabbitMQProperties.exchangeName())
        .build();
  }

  @Bean
  Queue queue() {
    return QueueBuilder
        .durable(rabbitMQProperties.queueName())
        .deadLetterExchange(rabbitMQProperties.deadLetterExchangeName())
        .build();
  }

  @Bean
  Binding binding() {
    return BindingBuilder
        .bind(queue())
        .to(exchange())
        .with(rabbitMQProperties.routingKey());
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
