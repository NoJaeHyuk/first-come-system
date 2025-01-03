package com.firstcomesystem.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductStore productStore;
    private final ProductReader productReader;

    @Override
    public Page<ProductInfo> getProductInfos(Pageable pageable) {
        return productReader.findAll(pageable)
                .map(ProductInfo::fromEntity);
    }

    @Override
    public ProductInfo getProductInfo(Long id) {
        Product product = productReader.getProduct(id);
        return new ProductInfo(product);
    }

    @Override
    public ProductInfo registerUser(ProductCommend commend) {
        Product initProduct = commend.toEntity();
        Product product = productStore.save(initProduct);
        return new ProductInfo(product);
    }
}
