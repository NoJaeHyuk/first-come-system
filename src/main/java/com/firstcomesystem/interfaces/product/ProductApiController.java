package com.firstcomesystem.interfaces.product;

import com.firstcomesystem.application.product.ProductFacade;
import com.firstcomesystem.common.response.CommonResponse;
import com.firstcomesystem.domain.product.ProductInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductFacade productFacade;

    @PostMapping
    public CommonResponse registerProduct(@RequestBody ProductDto.RegisterRequest request) {
        ProductInfo productInfo = productFacade.registerProduct(request.toCommand());
        ProductDto.ProductResponse response = new ProductDto.ProductResponse(productInfo);
        return CommonResponse.success(response);
    }

    @GetMapping("/{productId}")
    public CommonResponse getProductInfo(@RequestParam Long productId) {
        ProductInfo productInfo = productFacade.getProduct(productId);
        ProductDto.ProductResponse response = new ProductDto.ProductResponse(productInfo);
        return CommonResponse.success(response);
    }
}
