package br.com.btgpactual.app.services;

import br.com.btgpactual.app.dto.OrderResponseDto;
import br.com.btgpactual.app.model.Order;

public interface OrderService  {
  void create(Order order);
  OrderResponseDto findClientHistoric(Long clientId);
}
