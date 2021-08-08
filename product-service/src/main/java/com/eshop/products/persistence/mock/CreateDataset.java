package com.eshop.products.persistence.mock;

import com.eshop.products.persistence.model.FoodProduct;
import com.eshop.products.persistence.repository.FoodRepository;
import com.eshop.products.utils.ProductSubTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * mock data
 */
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CreateDataset {

    private final FoodRepository foodRepository;

    /**
     * mock products
     */
    @PostConstruct
    public void mockProducts() {
        FoodProduct freshSteak = FoodProduct.builder()
                .subType(ProductSubTypes.FRESH_FOOD)
                .id(UUID.randomUUID().toString())
                .name("fresh steak")
                .description("fresh steak from the butcher")
                .price(BigDecimal.valueOf(70))
                .currency("TND")
                .fabricationDate(OffsetDateTime.now().minusDays(1))
                .expirationDate(OffsetDateTime.now().plusWeeks(1))
                .imageUrl("C:\\Users\\Unlucky\\Documents\\Projects\\git\\eshop\\product-service\\src\\main\\resources\\mock-sources\\images\\fresh-steak.jpg")
                .build();

        FoodProduct sealedSteak = FoodProduct.builder()
                .subType(ProductSubTypes.SEALED_FOOD)
                .id(UUID.randomUUID().toString())
                .name("sealed steak")
                .description("sealed steak seasoned by the butcher")
                .price(BigDecimal.valueOf(90))
                .currency("TND")
                .fabricationDate(OffsetDateTime.now())
                .expirationDate(OffsetDateTime.now().plusDays(5))
                .imageUrl("C:\\Users\\Unlucky\\Documents\\Projects\\git\\eshop\\product-service\\src\\main\\resources\\mock-sources\\images\\sealed-steak.jpg")
                .build();

        FoodProduct frozenSteak = FoodProduct.builder()
                .subType(ProductSubTypes.FROZEN_FOOD)
                .id(UUID.randomUUID().toString())
                .name("frozen steak")
                .description("frozen steak from the supermarket")
                .price(BigDecimal.valueOf(50))
                .currency("TND")
                .fabricationDate(OffsetDateTime.now())
                .expirationDate(OffsetDateTime.now().plusWeeks(2))
                .imageUrl("C:\\Users\\Unlucky\\Documents\\Projects\\git\\eshop\\product-service\\src\\main\\resources\\mock-sources\\images\\frozen-steak.jpg")
                .build();

        foodRepository.save(freshSteak);
        foodRepository.save(sealedSteak);
        foodRepository.save(frozenSteak);
    }
}
