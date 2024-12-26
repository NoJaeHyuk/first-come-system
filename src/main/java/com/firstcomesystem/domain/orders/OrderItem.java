package com.firstcomesystem.domain.orders;

import com.firstcomesystem.domain.product.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer price;


    @Builder
    private OrderItem(Orders order, Integer quantity, Long productId, String productName, Integer price) {
        this.order = order;
        this.quantity = quantity;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
}
