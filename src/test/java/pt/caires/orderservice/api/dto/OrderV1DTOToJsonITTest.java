package pt.caires.orderservice.api.dto;

import static org.assertj.core.api.BDDAssertions.then;
import java.io.IOException;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

@JsonTest
class OrderV1DTOToJsonITTest {

  @Inject
  private JacksonTester<OrderV1DTO> jacksonTester;

  @Test
  void shouldSerialize() throws IOException {
    var orderV1DTO = new OrderV1DTO("id", "storeName", "itemName", 1);
    var expected =
        "{\"id\":\"id\",\"storeName\":\"storeName\",\"itemName\":\"itemName\",\"quantity\":1}";

    var jsonContent = jacksonTester.write(orderV1DTO);

    then(jsonContent.getJson())
        .isNotBlank()
        .isEqualTo(expected);
  }

}