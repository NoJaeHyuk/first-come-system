package com.firstcomesystem.domain.product;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ProductInfo {
    private final Long id;
    private final String name;
    private final String description;
    private final Integer price;
    private final Integer stock;

    public ProductInfo(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }
}
