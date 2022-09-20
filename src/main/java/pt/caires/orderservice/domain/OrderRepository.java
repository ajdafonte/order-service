package pt.caires.orderservice.domain;

public interface OrderRepository {

  String generateId();

  Order save(Order order);

}
