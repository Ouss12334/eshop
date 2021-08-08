package com.eshop.products.service;

import com.eshop.products.mapper.ProductMapper;
import com.eshop.products.model.Product;
import com.eshop.products.persistence.model.*;
import com.eshop.products.persistence.service.ProductDbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.eshop.products.utils.ProductSubTypes.*;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {

    private final ProductDbService productDbService;

    public List<Product> getProductsByType(String subType) {
        log.debug("fetching products of subtype '{}'", subType);
        Class<? extends com.eshop.products.persistence.model.Product> targetClass = null;
        switch (subType) {
            case FRESH_FOOD:
            case SEALED_FOOD:
            case FROZEN_FOOD:
                targetClass = FoodProduct.class;
                break;
            case PROTEIN_WORKOUT:
            case CREATINE_WORKOUT:
            case PRE_WORKOUT:
                targetClass = WorkoutProduct.class;
                break;
            case MASK_HEALTH:
            case MUSCLE_HEALTH:
                targetClass = HealthAndVitaminsProduct.class;
                break;
            case BODY_BEAUTY:
            case BATH_BEAUTY:
                targetClass = BeautyProduct.class;
                break;
            case FOOD_PET:
            case BATH_PET:
                targetClass = PetProduct.class;
                break;
            default:
                return Collections.emptyList();
        }

        List<? extends com.eshop.products.persistence.model.Product> products =
                productDbService.getProductsByType(targetClass, subType);
        if (products != null) {
            return ProductMapper.INSTANCE.toProductsApi(products);
        }
        return Collections.emptyList();
    }
}
