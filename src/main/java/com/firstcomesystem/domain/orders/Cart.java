package com.firstcomesystem.domain.orders;

import com.firstcomesystem.domain.users.entity.Users;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Enumerated(EnumType.STRING)
    private Cart.Status status;

    @OneToMany(mappedBy = "cart")
    private final List<CartItem> cartItems = new ArrayList<>();


    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ACTIVE("활성"),   // 활성화된 장바구니
        ORDERED("비활성");   // 주문 완료된 장바구니

        private final String description;

    }

    @Builder
    private Cart(Users user, Cart.Status status) {
        this.user = user;
        this.status = status;
    }

    public static Cart createCart(Users user) {
        return Cart.builder()
                .user(user)
                .status(Cart.Status.ACTIVE)
                .build();
    }

    public void addItem(CartItem cartItem) {
        cartItems.add(cartItem);
        cartItem.setCart(this);
    }


}
