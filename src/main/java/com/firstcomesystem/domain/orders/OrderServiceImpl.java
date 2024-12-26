package com.firstcomesystem.domain.orders;

import com.firstcomesystem.domain.product.Product;
import com.firstcomesystem.domain.product.ProductReader;
import com.firstcomesystem.domain.users.entity.Users;
import com.firstcomesystem.domain.users.repository.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderStore orderStore;
    private final UserReader userReader;
    private final CartReader cartReader;
    private final ProductReader productReader;

    @Override
    @Transactional
    public Long registerOrder(OrderCommend.RegisterOrder commend, Long userId) {
        Users user = userReader.gerUser(userId);
        Cart cart = cartReader.getById(commend.getCartId());

        // root 먼저 저장
        Orders savedOrder = orderStore.save(Orders.builder()
                .cart(cart)
                .user(user)
                .build());

        // item 넣는 로직
        // product에 대한 재고 감소처리도 이뤄져야 한다.
        for (OrderCommend.RegisterItem cartItem : commend.getItems()) {
            Product product = productReader.getProduct(cartItem.getProductId());

            // 재고 감소
            product.decreaseStock(cartItem.getQuantity());

            OrderItem orderItem = OrderItem.builder()
                    .order(savedOrder)
                    .productId(cartItem.getProductId())
                    .productName(cartItem.getProductName())
                    .quantity(cartItem.getQuantity())
                    .build();

            orderStore.save(orderItem);
        }

        //TODO: 추가적으로 cartItem에 대한 처리도 필요할 수도 있다.
        //TODO: 결제에 대한 부분이 들어온다면 금액 결제에 대한 부분이 들어올 수 있다.

        return savedOrder.getId();
    }
}
