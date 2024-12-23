package com.firstcomesystem.interfaces.product;

import com.firstcomesystem.application.product.ProductFacade;
import com.firstcomesystem.common.response.CommonResponse;
import com.firstcomesystem.domain.product.ProductInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductFacade productFacade;

    @PostMapping
    public CommonResponse registerProduct(ProductDto.RegisterRequest request) {
        ProductInfo productInfo = productFacade.registerUser(request.toCommand());
        return CommonResponse.success(productInfo);
    }
}
