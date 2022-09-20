package pt.caires.orderservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pt.caires.orderservice.api.dto.CreateOrderV1DTO;
import pt.caires.orderservice.api.dto.OrderV1DTO;

@RestController
@RequestMapping(value = "api/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderV1Controller {

  @PostMapping
  @ResponseStatus(value = HttpStatus.CREATED)
  public OrderV1DTO createOrder(@RequestBody CreateOrderV1DTO createOrderV1DTO) {
    return new OrderV1DTO("e3211be6-d0cc-4718-905d-ab933cc91ecb",
        "Bakery X",
        "Bread Y",
        1);
  }

}
