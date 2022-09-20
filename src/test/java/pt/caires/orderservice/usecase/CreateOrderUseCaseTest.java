package pt.caires.orderservice.usecase;

import static org.assertj.core.api.BDDAssertions.then;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.caires.orderservice.domain.Order;

class CreateOrderUseCaseTest {

  private CreateOrderUseCase createOrderUseCase;

  @BeforeEach
  void setUp() {
    this.createOrderUseCase = new CreateOrderUseCase();
  }

  @Test
  void shouldCreateAnOrder() {
    var expected = new Order("e3211be6-d0cc-4718-905d-ab933cc91ecb", "Bakery X", "Bread Y", 1);

    var result = createOrderUseCase.execute("Bakery X", "Bread Y", 1);

    then(result)
        .isNotNull()
        .isEqualTo(expected);
  }

}