package com.eshop.products.persistence.mock;

import com.eshop.products.persistence.model.FoodProduct;
import com.eshop.products.persistence.model.WorkoutProduct;
import com.eshop.products.persistence.repository.FoodRepository;
import com.eshop.products.persistence.repository.WorkoutRepository;
import com.eshop.products.persistence.service.ProductDbService;
import com.eshop.products.utils.ProductSubTypes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.UUID;

import static java.math.BigDecimal.ROUND_UNNECESSARY;

/**
 * mock data
 */
@Slf4j
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CreateDataset {

    private final FoodRepository foodRepository;
    private final WorkoutRepository workoutRepository;
    private final ProductDbService productService;

    /**
     * mock products
     */
    @PostConstruct
    public void mockProducts() {
        FoodProduct freshSteak = FoodProduct.builder()
                .subType(ProductSubTypes.FRESH_FOOD)
                .id(UUID.randomUUID().toString())
                .name("Fresh steak")
                .description("fresh steak from the butcher")
                .quantity(2)
                .weightGram(100)
                .unitPrice(BigDecimal.valueOf(70.255))
                .currency("TND")
                .fabricationDate(OffsetDateTime.now().minusDays(1))
                .expirationDate(OffsetDateTime.now().plusWeeks(1))
                .imageUrl("http://127.0.0.1:8887/fresh-steak.jpg")
                .build();

        FoodProduct freshEgg = FoodProduct.builder()
                .subType(ProductSubTypes.FRESH_FOOD)
                .id(UUID.randomUUID().toString())
                .name("Fresh eggs")
                .description("fresh natural eggs")
                .quantity(6)
                .weightGram(100)
                .discountPrice(BigDecimal.ONE)
                .unitPrice(new BigDecimal(2.99))
                .currency("USD")
                .fabricationDate(OffsetDateTime.now())
                .expirationDate(OffsetDateTime.now().plusWeeks(3))
                .imageUrl("http://127.0.0.1:8887/fresh-egg.jpg")
                .build();

        FoodProduct sealedSteak = FoodProduct.builder()
                .subType(ProductSubTypes.SEALED_FOOD)
                .id(UUID.randomUUID().toString())
                .name("Sealed steak")
                .description("sealed steak seasoned by the butcher")
                .quantity(1)
                .weightGram(100)
                .unitPrice(BigDecimal.valueOf(90))
                .currency("TND")
                .fabricationDate(OffsetDateTime.now())
                .expirationDate(OffsetDateTime.now().plusDays(5))
                .imageUrl("http://127.0.0.1:8887/sealed-steak.jpg")
                .build();

        FoodProduct frozenSteak = FoodProduct.builder()
                .subType(ProductSubTypes.FROZEN_FOOD)
                .id(UUID.randomUUID().toString())
                .name("Frozen steak")
                .description("frozen steak from the supermarket")
                .quantity(3)
                .weightGram(50)
                .unitPrice(BigDecimal.valueOf(50))
                .currency("TND")
                .fabricationDate(OffsetDateTime.now())
                .expirationDate(OffsetDateTime.now().plusWeeks(2))
                .imageUrl("http://127.0.0.1:8887/frozen-steak.jpg")
                .build();

        WorkoutProduct workoutProduct = WorkoutProduct.builder()
                .subType(ProductSubTypes.PROTEIN_WORKOUT)
                .id(UUID.randomUUID().toString())
                .name("Whey")
                .description("whey protein for workout")
                .quantity(1)
                .weightGram(1500)
                .unitPrice(BigDecimal.valueOf(450))
                .currency("TND")
                .fabricationDate(OffsetDateTime.now())
                .expirationDate(OffsetDateTime.now().plusWeeks(2))
                .imageUrl("http://127.0.0.1:8887/protein.jpg")
                .build();

        foodRepository.save(freshSteak);
        foodRepository.save(freshEgg);
        foodRepository.save(sealedSteak);
        foodRepository.save(frozenSteak);
        workoutRepository.save(workoutProduct);

        // test fetch
        log.debug("fetched fresh products {}", productService.getProductsByType(FoodProduct.class, ProductSubTypes.FRESH_FOOD).size());
    }
}
