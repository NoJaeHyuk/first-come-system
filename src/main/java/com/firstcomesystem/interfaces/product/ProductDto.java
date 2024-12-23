package com.firstcomesystem.interfaces.product;

import com.firstcomesystem.domain.product.ProductCommend;
import com.firstcomesystem.domain.product.ProductInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ProductDto {

    @Getter
    @Builder
    @ToString
    public static class RegisterRequest {
        private String name;
        private String description;
        private Integer price;
        private Integer stock;

        public ProductCommend toCommand() {
            return ProductCommend.builder()
                    .name(name)
                    .description(description)
                    .price(price)
                    .stock(stock)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class ProductResponse {
        private final Long id;
        private final String name;
        private final String description;
        private final Integer price;
        private final Integer stock;

        public ProductResponse(ProductInfo productInfo) {
            this.id = productInfo.getId();
            this.name = productInfo.getName();
            this.description = productInfo.getDescription();
            this.price = productInfo.getPrice();
            this.stock = productInfo.getStock();
        }
    }
}
