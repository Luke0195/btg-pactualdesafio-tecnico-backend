package br.com.btgpactual.app.dto;

import java.math.*;
import java.util.*;

import br.com.btgpactual.app.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderResponseDto implements Serializable{
  private Double totalValue;
  private Integer totalOrders;
  private List<OrderItem> itens;
}
