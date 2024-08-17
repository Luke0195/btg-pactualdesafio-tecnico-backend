package br.com.btgpactual.app.listerners;

import java.io.Serializable;
import java.util.Set;

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
public class Pedido implements Serializable{

   private Integer codigoPedido;
   private Integer codigoCliente;
   private Set<ItemPedido> itens;
}
