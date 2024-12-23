package com.firstcomesystem.interfaces.product;

import com.firstcomesystem.domain.product.ProductCommend;
import com.firstcomesystem.domain.users.dto.UserCommand;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ProductDto {

    @Getter
    @Builder
    @ToString
    public static class RegisterRequest {
        private final String name;
        private final String description;
        private final Integer price;
        private final Integer stock;

        public ProductCommend toCommand() {
            return ProductCommend.builder()
                    .name(name)
                    .description(description)
                    .price(price)
                    .stock(stock)
                    .build();
        }
    }
}
