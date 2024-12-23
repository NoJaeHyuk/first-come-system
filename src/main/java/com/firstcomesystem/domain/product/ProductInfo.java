package com.firstcomesystem.domain.product;

import lombok.Getter;
import lombok.ToString;

@Getter
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

    public static ProductInfo fromEntity(Product product) {
        return new ProductInfo(product);
    }
}
