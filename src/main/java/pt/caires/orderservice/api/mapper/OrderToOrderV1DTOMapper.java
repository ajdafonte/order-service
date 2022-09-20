package pt.caires.orderservice.api.mapper;

import javax.inject.Named;
import pt.caires.orderservice.api.dto.OrderV1DTO;
import pt.caires.orderservice.domain.Order;

@Named
public class OrderToOrderV1DTOMapper {

  public OrderV1DTO map(Order order) {
    return new OrderV1DTO(
        order.getId(),
        order.getStoreName(),
        order.getItemName(),
        order.getQuantity());
  }

}
