package com.eshop.products.persistence.repository;

import com.eshop.products.persistence.model.HealthAndVitaminsProduct;
import com.eshop.products.persistence.model.WorkoutProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * separate repository for health products.
 */
public interface WorkoutRepository extends JpaRepository<WorkoutProduct, String> {
}
