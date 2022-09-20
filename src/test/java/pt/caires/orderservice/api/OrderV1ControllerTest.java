package pt.caires.orderservice.api;

import static org.assertj.core.api.BDDAssertions.then;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pt.caires.orderservice.api.dto.CreateOrderV1DTO;
import pt.caires.orderservice.api.dto.OrderV1DTO;
import pt.caires.orderservice.api.mapper.OrderToOrderV1DTOMapper;
import pt.caires.orderservice.domain.Order;
import pt.caires.orderservice.usecase.CreateOrderUseCase;

@ExtendWith(MockitoExtension.class)
class OrderV1ControllerTest {

  @Mock
  private CreateOrderUseCase createOrderUseCase;
  @Mock
  private OrderToOrderV1DTOMapper orderToOrderV1DTOMapper;
  private OrderV1Controller controller;

  @BeforeEach
  void setUp() {
    this.controller = new OrderV1Controller(createOrderUseCase, orderToOrderV1DTOMapper);
  }

  @Test
  void shouldCreateAnOrder() {
    var createOrderV1DTO = new CreateOrderV1DTO("Bakery X", "Bread Y", 1);
    var order = new Order("e3211be6-d0cc-4718-905d-ab933cc91ecb", "Bakery X", "Bread Y", 1);
    var expected = new OrderV1DTO("e3211be6-d0cc-4718-905d-ab933cc91ecb", "Bakery X", "Bread Y", 1);
    BDDMockito.given(createOrderUseCase.execute("Bakery X", "Bread Y", 1))
        .willReturn(order);
    BDDMockito.given(orderToOrderV1DTOMapper.map(order))
        .willReturn(expected);

    var result = controller.createOrder(createOrderV1DTO);

    then(result)
        .isNotNull()
        .isEqualTo(expected);
  }

}