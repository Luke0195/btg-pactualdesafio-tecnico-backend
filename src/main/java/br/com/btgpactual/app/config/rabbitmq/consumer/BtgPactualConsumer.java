package br.com.btgpactual.app.config.rabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.btgpactual.app.listerners.ItemPedido;
import br.com.btgpactual.app.listerners.Pedido;
import br.com.btgpactual.app.model.Order;
import br.com.btgpactual.app.model.OrderItem;
import br.com.btgpactual.app.services.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import java.util.*;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@Component
public class BtgPactualConsumer {

  private final OrderServiceImpl orderServiceImpl;
  private final ObjectMapper objectMapper;

  @RabbitListener(queues = "${queue.name}")
  public void consumeMessage(@Payload Message message) throws Exception{
    Pedido pedido = objectMapper.readValue(message.getBody(), Pedido.class);
    Order order = parseMessageToOrder(pedido);
    orderServiceImpl.create(order);
  }

  private static Order parseMessageToOrder(Pedido pedido){
    List<OrderItem> itens = new ArrayList<OrderItem>();
    for(ItemPedido itemPedido: pedido.getItens()){
      itens.add(OrderItem.builder().name(itemPedido.getProduto()).price(itemPedido.getPreco()).quantity(itemPedido.getQuantidade()).build());
    }
    return Order.builder().clientId(pedido.getCodigoCliente()).orderId(pedido.getCodigoPedido()).itens(itens).build();
  }

}
