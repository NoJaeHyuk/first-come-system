package com.firstcomesystem.interfaces.order;

import com.firstcomesystem.application.order.CartFacade;
import com.firstcomesystem.common.response.CommonResponse;
import com.firstcomesystem.domain.orders.CartInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
