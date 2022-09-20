package pt.caires.orderservice.api;

import static org.assertj.core.api.BDDAssertions.then;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.caires.orderservice.api.dto.CreateOrderV1DTO;
import pt.caires.orderservice.api.dto.OrderV1DTO;

class OrderV1ControllerTest {

  private OrderV1Controller controller;

  @BeforeEach
  void setUp() {
    this.controller = new OrderV1Controller();
  }

  @Test
  void shouldCreateAnOrder() {
    var createOrderV1DTO = new CreateOrderV1DTO("Bakery X", "Bread Y", 1);
    var expected = new OrderV1DTO("e3211be6-d0cc-4718-905d-ab933cc91ecb", "Bakery X", "Bread Y", 1);

    var result = controller.createOrder(createOrderV1DTO);

    then(result)
        .isNotNull()
        .isEqualTo(expected);
  }

}