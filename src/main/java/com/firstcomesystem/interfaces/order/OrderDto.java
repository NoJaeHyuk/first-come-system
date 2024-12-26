package com.firstcomesystem.interfaces.order;

import com.firstcomesystem.domain.orders.OrderCommend;
import lombok.Getter;

import java.util.List;

public class OrderDto {

    @Getter
    public static class RegisterRequest {
        private Long cartId;
        private List<OrderCommend.RegisterItem> items;

        public OrderCommend.RegisterOrder toCommand() {
            return OrderCommend.RegisterOrder.builder()
                    .cartId(cartId)
                    .items(items)
                    .build();
        }
    }


    @Getter
    public static class RegisterItem {
        private Long productId;
        private String productName;
        private Integer price;
        private Integer quantity;
    }
}
