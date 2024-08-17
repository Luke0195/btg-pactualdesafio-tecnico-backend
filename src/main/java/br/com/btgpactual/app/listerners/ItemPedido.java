package br.com.btgpactual.app.listerners;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ItemPedido implements Serializable{
  private String produto;
  private Integer quantidade;
  private BigDecimal preco;

}
