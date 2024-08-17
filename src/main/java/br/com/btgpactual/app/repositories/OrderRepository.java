package br.com.btgpactual.app.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.btgpactual.app.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
  
  @Query(value = "{clientId:?0}")
  Optional<Order> findClientHistoric(Long clientId);
}
