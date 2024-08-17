package br.com.btgpactual.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.btgpactual.app.model.Order;
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

}
