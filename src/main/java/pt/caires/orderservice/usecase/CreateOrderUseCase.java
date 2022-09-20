package pt.caires.orderservice.usecase;

import javax.inject.Named;
import pt.caires.orderservice.domain.Order;
import pt.caires.orderservice.domain.OrderRepository;

@Named
public class CreateOrderUseCase {

  private final OrderRepository orderRepository;

  public CreateOrderUseCase(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public Order execute(String storeName, String itemName, int quantity) {
    var order = new Order(orderRepository.generateId(),
        storeName,
        itemName,
        quantity);
    return orderRepository.save(order);
  }

}
