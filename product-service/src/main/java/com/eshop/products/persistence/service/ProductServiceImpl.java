package com.eshop.products.persistence.service;

import com.eshop.products.persistence.model.FoodProduct;
import com.eshop.products.persistence.model.Product;
import com.eshop.products.persistence.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {

    private final FoodRepository foodRepository;

    @Override
    public List<Product> getProductsByType(Class<? extends Product> productType, String subType) {
        Example<FoodProduct> example = Example.of(FoodProduct.builder().subType(subType).build(), ExampleMatcher.matching());
        return null;
    }
}
