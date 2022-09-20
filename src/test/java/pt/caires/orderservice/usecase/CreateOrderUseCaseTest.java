package pt.caires.orderservice.usecase;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pt.caires.orderservice.domain.Order;
import pt.caires.orderservice.domain.OrderRepository;

@ExtendWith(MockitoExtension.class)
class CreateOrderUseCaseTest {

  @Mock
  private OrderRepository orderRepository;

  private CreateOrderUseCase createOrderUseCase;

  @BeforeEach
  void setUp() {
    this.createOrderUseCase = new CreateOrderUseCase(orderRepository);
  }

  @Test
  void shouldCreateAnOrder() {
    var expected = new Order("e3211be6-d0cc-4718-905d-ab933cc91ecb", "Bakery X", "Bread Y", 1);
    given(orderRepository.generateId()).willReturn("e3211be6-d0cc-4718-905d-ab933cc91ecb");
    given(orderRepository.save(expected)).willReturn(expected);

    var result = createOrderUseCase.execute("Bakery X", "Bread Y", 1);

    then(result)
        .isNotNull()
        .isEqualTo(expected);
  }

}