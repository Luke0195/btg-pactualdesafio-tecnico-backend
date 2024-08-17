package br.com.btgpactual.app.config.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BtgPactualConsumer {

  @RabbitListener(queues = "${queue.name}")
  public void consumeMessage(@Payload String message){
    log.info("Mensagem recebida " + message);
  }

}
