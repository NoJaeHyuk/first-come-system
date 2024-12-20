package com.firstcomesystem.domain.orders;

import com.firstcomesystem.domain.users.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
    private Orders.Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ACTIVE("활성"),   // 활성화된 장바구니
        ORDERED("비활성");   // 주문 완료된 장바구니

        private final String description;
    }
}
