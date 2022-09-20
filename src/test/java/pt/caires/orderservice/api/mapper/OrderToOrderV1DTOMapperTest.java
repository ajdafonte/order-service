package pt.caires.orderservice.api.mapper;

import static org.assertj.core.api.BDDAssertions.then;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.caires.orderservice.api.dto.OrderV1DTO;
import pt.caires.orderservice.domain.Order;

class OrderToOrderV1DTOMapperTest {

  private OrderToOrderV1DTOMapper mapper;

  @BeforeEach
  void setUp() {
    this.mapper = new OrderToOrderV1DTOMapper();
  }

  @Test
  void shouldMap() {
    var order = new Order("id", "storeName", "itemName", 1);
    var expected = new OrderV1DTO("id", "storeName", "itemName", 1);

    var result = mapper.map(order);

    then(result)
        .isNotNull()
        .isEqualTo(expected);
  }

}