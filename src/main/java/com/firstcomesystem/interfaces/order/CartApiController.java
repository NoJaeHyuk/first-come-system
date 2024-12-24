package com.firstcomesystem.interfaces.order;

import com.firstcomesystem.application.order.CartFacade;
import com.firstcomesystem.common.response.CommonResponse;
import com.firstcomesystem.domain.orders.CartInfo;
import com.firstcomesystem.domain.orders.CartItemInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartApiController {

    private final CartFacade cartFacade;

    @PostMapping
    public CommonResponse registerCartItem(@RequestParam Long userId, @RequestBody CartDto.RegisterRequest request) {
        CartInfo cartInfo = cartFacade.registerCart(userId, request.toCommand());
        return CommonResponse.success(cartInfo.getId());
    }

    @GetMapping("/items")
    public CommonResponse getActiveCartItems(@RequestParam Long userId) {
        List<CartItemInfo> cartItemInfos = cartFacade.getActiveCartItems(userId);
        List<CartDto.ItemResponse> responses = cartItemInfos.stream()
                .map(CartDto.ItemResponse::toItemResponse)
                .collect(Collectors.toList());
        return CommonResponse.success(responses);
    }

    @PatchMapping("/items/{cartItemId}/quantity")
    public CommonResponse updateCartItemQuantity(
            @PathVariable Long cartItemId,
            @RequestParam Long userId,
            @RequestParam int quantityChange
    ) {
        cartFacade.updateCartItemQuantity(userId, cartItemId, quantityChange);
        return CommonResponse.success("정상처리되었습니다.");
    }
}
