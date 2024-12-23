package com.firstcomesystem.domain.product;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ProductCommend {
    private final String name;
    private final String description;
    private final Integer price;
    private final Integer stock;

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .stock(stock)
                .build();
    }
}

