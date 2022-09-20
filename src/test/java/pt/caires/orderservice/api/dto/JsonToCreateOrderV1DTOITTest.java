package pt.caires.orderservice.api.dto;

import static org.assertj.core.api.BDDAssertions.then;
import java.io.IOException;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

@JsonTest
class JsonToCreateOrderV1DTOITTest {

  @Inject
  private JacksonTester<CreateOrderV1DTO> jacksonTester;

  @Test
  void shouldDeserialize() throws IOException {
    var json = "{\"storeName\":\"storeName\",\"itemName\":\"itemName\",\"quantity\":1}";
    var expected = new CreateOrderV1DTO("storeName", "itemName", 1);

    var result = jacksonTester.parse(json).getObject();

    then(result)
        .isNotNull()
        .isEqualTo(expected);
  }

}