package com.firstcomesystem.domain.orders;

import com.firstcomesystem.domain.product.Product;
import com.firstcomesystem.domain.product.ProductReader;
import com.firstcomesystem.domain.users.entity.Users;
import com.firstcomesystem.domain.users.repository.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderStore orderStore;
    private final OrderReader orderReader;
    private final UserReader userReader;
    private final CartReader cartReader;
    private final ProductReader productReader;

    @Override
    @Transactional
    public Long registerOrder(OrderCommend.RegisterOrder commend, Long userId) {
        Users user = userReader.getUser(userId);
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

    @Override
    @Transactional
    public Long cancelOrder(Long orderId) {
        Orders order = orderReader.getById(orderId);

        // 배송 상태 확인
        if (order.getStatus() == Orders.Status.IN_DELIVERY || order.getStatus() == Orders.Status.DELIVERY_COMPLETE) {
            throw new IllegalStateException("배송 중이거나 완료된 주문은 취소할 수 없습니다.");
        }

        // 재고 복구
        for (OrderItem orderItem : order.getOrderItems()) {
            Product product = productReader.getProduct(orderItem.getProductId());
            product.increaseStock(orderItem.getQuantity());
        }

        // 주문 상태 변경
        order.updateStatus(Orders.Status.CANCELLED);

        return order.getId();
    }

    @Override
    @Transactional
    public void returnOrder(Long orderId) {
        // 주문 조회
        Orders order = orderReader.getById(orderId);

        // 주문 상태 확인
        if (order.getStatus() != Orders.Status.DELIVERY_COMPLETE) {
            throw new IllegalStateException("배송 완료된 주문만 반품이 가능합니다.");
        }

        // 반품 가능 날짜 검증
        if (order.getOrderAt().plusDays(1).isBefore(ZonedDateTime.now())) {
            throw new IllegalStateException("반품 가능 기간이 지났습니다.");
        }

        // 재고 복구 예약 및 상태 변경
        for (OrderItem orderItem : order.getOrderItems()) {
            Product product = productReader.getProduct(orderItem.getProductId());
            // scheduleRestock(orderItem.getQuantity(), product);
        }

        order.updateStatus(Orders.Status.RETURN_REQUESTED);
    }

    private void scheduleRestock(int quantity, Product product) {
        // 예: 비동기 작업 또는 특정 날짜에 실행될 스케줄러를 등록
        // 단순히 예제를 위해 바로 재고 증가
        product.increaseStock(quantity);
    }
}
