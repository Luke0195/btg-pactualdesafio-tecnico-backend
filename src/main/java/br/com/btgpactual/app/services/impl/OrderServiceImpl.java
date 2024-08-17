package br.com.btgpactual.app.services.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.btgpactual.app.dto.OrderResponseDto;
import br.com.btgpactual.app.model.Order;
import br.com.btgpactual.app.model.OrderItem;
import br.com.btgpactual.app.repositories.OrderRepository;
import br.com.btgpactual.app.services.OrderService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class OrderServiceImpl implements OrderService {

  private final  OrderRepository orderRepository;
  @Override
  public void create(Order order) {
     orderRepository.save(order);
  }
  @Override
  public OrderResponseDto findClientHistoric(Long clientId) {
    Order order = orderRepository.findClientHistoric(clientId).orElseThrow(() -> new RuntimeException("client_id not found!"));
    double value = 0;
    for(OrderItem item: order.getItens()){
     value+= item.getQuantity() * item.getPrice().doubleValue();
    }
    
    return OrderResponseDto.builder()
      .totalOrders(order.getItens().size())
      .totalValue((double)Math.round(value))
      .itens(order.getItens())
    .build();
  }

  

}
