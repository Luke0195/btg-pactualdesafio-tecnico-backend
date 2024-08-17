package br.com.btgpactual.app.model;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Document(collection = "orders")
public class Order implements Serializable {
  @MongoId
  private Integer orderId;
  private Integer clientId;
  private Set<OrderItem> itens;
}
