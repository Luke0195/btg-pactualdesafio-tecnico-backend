package br.com.btgpactual.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.btgpactual.app.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {

}
