package com.js0507dev.api2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

@ConfigurationProperties("rabbitmq")
@ConfigurationPropertiesBinding
public record RabbitMQProperties(String queueName, String exchangeName, String routingKey,
                                 String deadLetterExchangeName) {
}
