package com.firstcomesystem.interfaces.order;

import com.firstcomesystem.domain.orders.Cart;
import com.firstcomesystem.domain.orders.CartItemCommend;
import com.firstcomesystem.domain.product.Product;
import com.firstcomesystem.domain.product.ProductCommend;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
}
