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
import pt.caires.orderservice.api.mapper.OrderToOrderV1DTOMapper;
import pt.caires.orderservice.usecase.CreateOrderUseCase;

@RestController
@RequestMapping(value = "api/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderV1Controller {

  private final CreateOrderUseCase createOrderUseCase;
  private final OrderToOrderV1DTOMapper orderToOrderV1DTOMapper;

  public OrderV1Controller(CreateOrderUseCase createOrderUseCase,
      OrderToOrderV1DTOMapper orderToOrderV1DTOMapper) {
    this.createOrderUseCase = createOrderUseCase;
    this.orderToOrderV1DTOMapper = orderToOrderV1DTOMapper;
  }

  @PostMapping
  @ResponseStatus(value = HttpStatus.CREATED)
  public OrderV1DTO createOrder(@RequestBody CreateOrderV1DTO createOrderV1DTO) {
    return orderToOrderV1DTOMapper.map(
        createOrderUseCase.execute(createOrderV1DTO.storeName(),
            createOrderV1DTO.itemName(),
            createOrderV1DTO.quantity()));
  }

}
