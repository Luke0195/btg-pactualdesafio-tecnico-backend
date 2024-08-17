package br.com.btgpactual.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.btgpactual.app.dto.OrderResponseDto;
import br.com.btgpactual.app.services.impl.OrderServiceImpl;
import lombok.AllArgsConstructor;




@AllArgsConstructor
@RestController
@RequestMapping(value="/orders")
public class OrderController {

  private final OrderServiceImpl serviceImpl;
  
  @GetMapping(value = "/{id}/historic")
  public ResponseEntity<OrderResponseDto> getMethodName(@PathVariable Long id) {
      OrderResponseDto responseDto = serviceImpl.findClientHistoric(id);
      return ResponseEntity.status(HttpStatus.OK).body(responseDto);
  }
  

}
