package com.eshop.products.persistence.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WorkoutProduct extends Product {
    @Builder
    public WorkoutProduct(String id, String name, String description, OffsetDateTime fabricationDate, OffsetDateTime expirationDate, BigDecimal price, String currency, String imageUrl, String subType) {
        super(id, name, description, fabricationDate, expirationDate, price, currency, imageUrl, subType);
    }
}
