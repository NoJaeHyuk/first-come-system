package com.firstcomesystem.domain.orders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


public class OrderCommend {

    @Getter
    public static class RegisterOrder {
        private Long cartId;
        private List<RegisterItem> items;

        @Builder
        public RegisterOrder(Long cartId, List<RegisterItem> items) {
            this.cartId = cartId;
            this.items = items;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class RegisterItem {
        private Long productId;
        private String productName;
        private Integer price;
        private Integer quantity;
    }
}
