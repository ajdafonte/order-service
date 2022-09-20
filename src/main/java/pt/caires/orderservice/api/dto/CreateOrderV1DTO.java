package pt.caires.orderservice.api.dto;

public record CreateOrderV1DTO(String storeName, String itemName, int quantity) {
}

