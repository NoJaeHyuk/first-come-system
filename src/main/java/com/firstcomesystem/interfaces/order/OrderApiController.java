package com.firstcomesystem.interfaces.order;

import com.firstcomesystem.application.order.OrderFacade;
import com.firstcomesystem.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderFacade orderFacade;

    @PostMapping
    public CommonResponse registerOrder(@RequestParam Long userId, @RequestBody OrderDto.RegisterRequest request) {
        Long resultData = orderFacade.registerOrder(request.toCommand(), userId);
        return CommonResponse.success(resultData);
    }


    @PatchMapping("/{orderId}/cancel")
    public CommonResponse cancelOrder(@PathVariable Long orderId) {
        Long resultData = orderFacade.cancelOrder(orderId);
        return CommonResponse.success(resultData);
    }
}
