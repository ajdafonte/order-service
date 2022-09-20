package pt.caires.orderservice.usecase;

import javax.inject.Named;
import pt.caires.orderservice.domain.Order;

@Named
public class CreateOrderUseCase {
  public Order execute(String storeName, String itemName, int quantity) {
    return new Order("e3211be6-d0cc-4718-905d-ab933cc91ecb", "Bakery X", "Bread Y", 1);
  }

}
