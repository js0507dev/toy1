package com.js0507dev.api2.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BoardConsumer {
  @RabbitListener(queues = "${rabbitmq.queue_name}")
  public void consume(Board board) {
    log.info("Board consumed: {}", board);
  }
}
