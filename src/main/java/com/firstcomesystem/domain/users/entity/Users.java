package com.firstcomesystem.domain.users.entity;

import com.firstcomesystem.domain.AbstractEntity;
import com.firstcomesystem.domain.orders.Cart;
import com.firstcomesystem.domain.orders.Orders;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Users extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Cart> carts = new ArrayList<>();

    @Builder
    private Users(String email, String password, String name, String phoneNumber, String address) {
        if(StringUtils.isEmpty(email)) throw new RuntimeException();
        if(StringUtils.isEmpty(password)) throw new RuntimeException();
        if(StringUtils.isEmpty(name)) throw new RuntimeException();
        if(StringUtils.isEmpty(phoneNumber)) throw new RuntimeException();
        if(StringUtils.isEmpty(address)) throw new RuntimeException();

        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
