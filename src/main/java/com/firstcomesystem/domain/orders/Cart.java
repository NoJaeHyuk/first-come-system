package com.firstcomesystem.domain.orders;

import com.firstcomesystem.common.exception.EntityNotFoundException;
import com.firstcomesystem.domain.AbstractEntity;
import com.firstcomesystem.domain.users.entity.Users;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Cart extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Enumerated(EnumType.STRING)
    private Cart.Status status;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<CartItem> cartItems = new ArrayList<>();

    public void removeCartItems(List<Long> itemIds) {
        List<CartItem> itemsToRemove = cartItems.stream()
                .filter(item -> itemIds.contains(item.getId()))
                .toList();

        if (itemsToRemove.isEmpty()) {
            throw new IllegalArgumentException("삭제 가능한 항목이 없습니다.");
        }
        cartItems.removeAll(itemsToRemove);
    }


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

    public void changeCartItemQuantity(Long cartItemId, Integer quantity) {
        CartItem item = cartItems.stream()
                .filter(i -> i.getId() == cartItemId)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));

        item.changQuantity(quantity);
    }


}
