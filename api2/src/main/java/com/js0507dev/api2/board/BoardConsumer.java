package com.js0507dev.api2.board;

import com.js0507dev.api2.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BoardConsumer {
  @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
  public void consume(Board board) {
    log.info("Board consumed: {}", board);
  }
}
