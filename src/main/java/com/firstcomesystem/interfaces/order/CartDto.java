package com.firstcomesystem.interfaces.order;

import com.firstcomesystem.domain.orders.Cart;
import com.firstcomesystem.domain.orders.CartItemCommend;
import com.firstcomesystem.domain.orders.CartItemInfo;
import com.firstcomesystem.domain.product.Product;
import com.firstcomesystem.domain.product.ProductCommend;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class CartDto {

    @Getter
    public static class RegisterRequest {
        private Long productId;
        private Integer quantity;

        public CartItemCommend toCommand() {
            return CartItemCommend.builder()
                    .productId(productId)
                    .quantity(quantity)
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    public static class ItemResponse {
        private Long cartItemId;
        private Long productId;
        private String productName;
        private Integer quantity;
        private Integer price;

        public static CartDto.ItemResponse toItemResponse(CartItemInfo cartItemInfo) {
            return new CartDto.ItemResponse(
                    cartItemInfo.getId(),
                    cartItemInfo.getProductId(),
                    cartItemInfo.getProductName(),
                    cartItemInfo.getQuantity(),
                    cartItemInfo.getPrice()
            );
        }
    }

}
