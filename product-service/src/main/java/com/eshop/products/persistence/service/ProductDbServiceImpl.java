package com.eshop.products.persistence.service;

import com.eshop.products.persistence.model.*;
import com.eshop.products.persistence.repository.BeautyRepository;
import com.eshop.products.persistence.repository.FoodRepository;
import com.eshop.products.persistence.repository.HealthRepository;
import com.eshop.products.persistence.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductDbServiceImpl implements ProductDbService {

    private final FoodRepository foodRepository;
    private final BeautyRepository beautyRepository;
    private final HealthRepository healthRepository;
    private final WorkoutRepository workoutRepository;

    @Override
    public List<? extends Product> getProductsByType(Class<? extends Product> productType, String subType) {
        // switch with class names didnt work, so using if
        // food
        if (productType.getCanonicalName().equals(FoodProduct.class.getCanonicalName())) {
            log.debug("fetching food");
            return foodRepository.findAllBySubType(subType);
        } else if (productType.getCanonicalName().equals(BeautyProduct.class.getCanonicalName())) {
            // beauty
            log.debug("fetching beauty");
            return beautyRepository.findAllBySubType(subType);
        } else if (productType.getCanonicalName().equals(HealthAndVitaminsProduct.class.getCanonicalName())) {
            // health
            log.debug("fetching health");
            return healthRepository.findAllBySubType(subType);
        } else if (productType.getCanonicalName().equals(WorkoutProduct.class.getCanonicalName())) {
            // workout
            log.debug("fetching workout");
            return workoutRepository.findAllBySubType(subType);
        }
        return null;
    }
}
