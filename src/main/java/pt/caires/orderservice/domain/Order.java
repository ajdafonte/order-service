package pt.caires.orderservice.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Order {
  private final String id;
  private final String storeName;
  private final String itemName;
  private final int quantity;

  public Order(String id, String storeName, String itemName, int quantity) {
    this.id = id;
    this.storeName = storeName;
    this.itemName = itemName;
    this.quantity = quantity;
  }

  public String getId() {
    return id;
  }

  public String getStoreName() {
    return storeName;
  }

  public String getItemName() {
    return itemName;
  }

  public int getQuantity() {
    return quantity;
  }

}
