package com.eshop.products.persistence.repository;

import com.eshop.products.persistence.model.FoodProduct;
import com.eshop.products.persistence.model.HealthAndVitaminsProduct;
import com.eshop.products.persistence.model.WorkoutProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * separate repository for health products.
 */
public interface WorkoutRepository extends JpaRepository<WorkoutProduct, String> {
    /**
     * find by subtype
     */
    List<WorkoutProduct> findAllBySubType(String subType);
}
